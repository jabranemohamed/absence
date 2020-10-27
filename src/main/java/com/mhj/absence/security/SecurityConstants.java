package com.mhj.absence.security;

import com.mhj.absence.SpringApplicationContext;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class SecurityConstants {

    @Value("${expiration.time}")
    private long EXPIRATION_TIME;

    @Value("${password.reset.time}")
    private long PASSWORD_RESET_EXPIRATION_TIME;

    @Value("$token.prefix}")
    private  String TOKEN_PREFIX;

    @Value("$header.prefix}")
    private String HEADER_STRING;

    @Value("$sign.up}")
    private String SIGN_UP_URL;

    @Value("$verification.email.url}")
    private String VERIFICATION_EMAIL_URL;

    @Value("$password.reset.request.url}")
    private String PASSWORD_RESET_REQUEST_URL;

    @Value("$password.reset.url}")
    private String PASSWORD_RESET_URL;

    public String getTokenSecret()
    {
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");
        return appProperties.getTokenSecret();
    }

}
