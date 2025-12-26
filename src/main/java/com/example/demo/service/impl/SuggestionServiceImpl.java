package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.SuggestionService;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    @Override
    public String generateSuggestion(long farmId) {
        return "Suggestion generated";
    }
}
