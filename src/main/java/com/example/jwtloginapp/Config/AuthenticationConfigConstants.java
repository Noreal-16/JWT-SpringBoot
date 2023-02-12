package com.example.jwtloginapp.Config;

public class AuthenticationConfigConstants {
    public static final String SECRET = "JavaSecretKey";
    public static final long EXPIRATION_TIME = 864000000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization ";
    public static final String SING_UP_URL = "/api/user";
}
