package com.example.demo.service.impl;

import com.example.demo.dto.SuggestionResponse;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    @Override
    public SuggestionResponse generateSuggestion(Long farmId) {
        return new SuggestionResponse();
    }
}
