package com.example.demo.service;

import com.example.demo.dto.SuggestionResponse;

public interface SuggestionService {

    // 🔴 TEST EXPECTS THIS NAME
    SuggestionResponse generateSuggestion(long farmId);
}
