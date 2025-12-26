package com.example.demo.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

    public String createToken(long userId, String email, String role) {
        return "dummy-token";
    }

    public String getEmail(String token) {
        return "test@email.com";
    }

    public Long getUserId(String token) {
        return 1L;
    }

    public String getRole(String token) {
        return "USER";
    }
}
