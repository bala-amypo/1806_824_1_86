package com.example.demo.service;

import com.example.demo.entity.Suggestion;

public interface SuggestionService {

    Suggestion generate(long cropId);

    Suggestion getSuggestion(long id);
}
