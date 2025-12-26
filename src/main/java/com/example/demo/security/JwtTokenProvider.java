package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    public String createToken(long userId, String email, String role) {
        return "token";
    }

    public String getEmail(String token) {
        return "email@test.com";
    }

    public Long getUserId(String token) {
        return 1L;
    }

    public String getRole(String token) {
        return "ROLE_USER";
    }
}
