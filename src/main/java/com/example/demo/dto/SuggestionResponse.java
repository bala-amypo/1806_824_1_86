package com.example.demo.dto;

public class SuggestionResponse {

    private int statusCodeValue;

    public SuggestionResponse() {}

    public SuggestionResponse(int statusCodeValue) {
        this.statusCodeValue = statusCodeValue;
    }

    // ✅ REQUIRED by tests
    public int getStatusCodeValue() {
        return statusCodeValue;
    }
}
