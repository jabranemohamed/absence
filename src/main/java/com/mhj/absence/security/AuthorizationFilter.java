package com.mhj.absence.security;

import com.mhj.absence.domain.User;
import com.mhj.absence.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter extends BasicAuthenticationFilter {
    private final UserRepository userRepository;
    private final SecurityConstants securityConstants;

    public AuthorizationFilter(AuthenticationManager authManager, UserRepository userRepository,SecurityConstants securityConstants) {
        super(authManager);
        this.userRepository = userRepository;
        this.securityConstants = securityConstants;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {

        String header = req.getHeader(this.securityConstants.getHEADER_STRING());

        if (header == null || !header.startsWith(this.securityConstants.getTOKEN_PREFIX())) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(this.securityConstants.getHEADER_STRING());

        if (token != null) {

            token = token.replace(this.securityConstants.getTOKEN_PREFIX(), "");

            String user = Jwts.parser()
                    .setSigningKey( this.securityConstants.getTokenSecret() )
                    .parseClaimsJws( token )
                    .getBody()
                    .getSubject();

            if (user != null) {
                User userEntity = userRepository.findByEmail(user);
                if(userEntity == null) return null;

                UserPrincipal userPrincipal = new UserPrincipal(userEntity);
                return new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
            }

            return null;
        }

        return null;
    }

}

