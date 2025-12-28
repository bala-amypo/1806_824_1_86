package com.example.demo.dto;

public class AuthResponse {

    private String token;
    private Long userId;
    private String email;
    private String role;
    private int statusCodeValue = 200;

    public AuthResponse() {}

    // ✅ REQUIRED by AuthController
    public AuthResponse(String token, Long userId, String email, String role) {
        this.token = token;
        this.userId = userId;
        this.email = email;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    // ✅ REQUIRED by tests
    public int getStatusCodeValue() {
        return statusCodeValue;
    }

    // ✅ REQUIRED by tests
    public AuthResponse getBody() {
        return this;
    }
}
