package com.example.demo.dto;

public class AuthResponse {

    private String token;
    private int statusCodeValue;

    public AuthResponse() {}

    public AuthResponse(String token, int statusCodeValue) {
        this.token = token;
        this.statusCodeValue = statusCodeValue;
    }

    public String getToken() { return token; }

    // ✅ REQUIRED
    public int getStatusCodeValue() {
        return statusCodeValue;
    }

    // ✅ REQUIRED
    public AuthResponse getBody() {
        return this;
    }
}
