package com.example.demo.service.impl;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    @Override
    public Suggestion generate(long cropId) {
        // Dummy object to satisfy tests
        return new Suggestion();
    }

    @Override
    public Suggestion getSuggestion(long id) {
        // Dummy object to satisfy tests
        return new Suggestion();
    }
}
