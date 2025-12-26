package com.example.demo.dto;

public class SuggestionResponse {

    private String suggestion;

    public SuggestionResponse() {
    }

    public SuggestionResponse(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
}
