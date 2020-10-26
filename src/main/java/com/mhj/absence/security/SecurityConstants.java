package com.mhj.absence.security;

import com.mhj.absence.SpringApplicationContext;
import org.springframework.beans.factory.annotation.Value;

public class SecurityConstants {

    @Value("${expiration.time}")
    public static long EXPIRATION_TIME;

    @Value("${password.reset.time}")
    public static long PASSWORD_RESET_EXPIRATION_TIME;

    @Value("$token.prefix}")
    public static String TOKEN_PREFIX;

    @Value("$header.prefix}")
    public static String HEADER_STRING;

    @Value("$sign.up}")
    public static String SIGN_UP_URL;

    @Value("$verification.email.url}")
    public static String VERIFICATION_EMAIL_URL;

    @Value("$password.reset.request.url}")
    public static String PASSWORD_RESET_REQUEST_URL;

    @Value("$password.reset.url}")
    public static String PASSWORD_RESET_URL;

    public static String getTokenSecret()
    {
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");
        return appProperties.getTokenSecret();
    }

}
