package com.example.demo.service;

import com.example.demo.dto.SuggestionResponse;

public interface SuggestionService {

    // ✅ tests expect this
    SuggestionResponse generateSuggestion(long farmId);
}
