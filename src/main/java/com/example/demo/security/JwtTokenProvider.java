package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private final String SECRET = "secret";

    public String createToken(Long userId, String email, String role) {
        return Jwts.builder()
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public boolean validateToken(String token) {
        Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        return true;
    }

    public String getEmail(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token).getBody();
        return claims.get("email", String.class);
    }

    public Long getUserId(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token).getBody();
        return claims.get("userId", Long.class);
    }

    public String getRole(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token).getBody();
        return claims.get("role", String.class);
    }
}
