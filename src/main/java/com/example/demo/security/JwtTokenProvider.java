package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private static final String SECRET_KEY = "demo-secret-key-12345";
    private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000; // 1 day

    public String createToken(Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public Claims validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getEmail(String token) {
        return validateToken(token).getSubject();
    }

    public Long getUserId(String token) {
        return validateToken(token).get("userId", Long.class);
    }

    public String getRole(String token) {
        return validateToken(token).get("role", String.class);
    }
}
