package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Suggestion;

@Service
public class SuggestionService {

    public Suggestion generateSuggestion(Long farmId) {
        return new Suggestion();
    }

    public Suggestion getSuggestion(Long suggestionId) {
        return new Suggestion();
    }

    public List<Suggestion> listFarmSuggestions(Long farmId) {
        return List.of();
    }
}
