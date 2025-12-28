package com.example.demo.service;

import com.example.demo.dto.SuggestionResponse;

public interface SuggestionService {

    // ✅ Controller + tests use THIS
    SuggestionResponse getSuggestion(Long farmId);
}
