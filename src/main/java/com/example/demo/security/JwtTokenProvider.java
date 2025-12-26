package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String createToken(Long userId, String email, String role) {
        return userId + "|" + email + "|" + role;
    }

    public boolean validateToken(String token) {
        return token != null;
    }

    public String getEmail(String token) {
        return token.split("\\|")[1];
    }

    public Long getUserId(String token) {
        return Long.parseLong(token.split("\\|")[0]);
    }

    public String getRole(String token) {
        return token.split("\\|")[2];
    }
}
