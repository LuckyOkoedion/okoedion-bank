package com.lucky.OkoedionBank.Pojo;

public final class SecurityConstants {
    public static final String SIGN_UP_URL = "/user/register";
    public static final String LOGIN_URL = "/user/login";
//    TODO - Change with another of 512  bytes and Hide and get with System.env
//    public static final String KEY = System.getenv("JWT_KEY");
    public static final String KEY = "q3t6w9z$C&F)J@NcQfTjWnZr4u7x!A%D*G-KaPdSgUkXp2s5v8y/B?E(H+MbQeTh";
    public static final String HEADER_NAME = "Authorization";
    public static final Long EXPIRATION_TIME = 1000L*60*30; // 30 minutes
}

