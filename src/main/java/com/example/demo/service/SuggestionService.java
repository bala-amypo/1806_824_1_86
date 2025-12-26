package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Suggestion;

public interface SuggestionService {

    Suggestion generateSuggestion(long farmId);
}
