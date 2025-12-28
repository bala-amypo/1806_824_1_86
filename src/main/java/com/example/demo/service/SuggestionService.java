package com.example.demo.service;

import com.example.demo.dto.SuggestionResponse;

public interface SuggestionService {
    SuggestionResponse getSuggestion(Long farmId);
}
