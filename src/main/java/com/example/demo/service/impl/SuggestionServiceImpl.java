package com.example.demo.service.impl;

import com.example.demo.entity.Suggestion;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository repo;

    @Override
    public Suggestion generateSuggestion(long farmId) {
        return repo.save(
                Suggestion.builder()
                        .farmId(farmId)
                        .suggestedCrops("Rice,Wheat")
                        .build()
        );
    }

    @Override
    public Suggestion getSuggestion(long id) {
        return repo.findById(id).orElseThrow();
    }
}
