package com.example.demo.service.impl;

import com.example.demo.entity.Suggestion;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository repo;

    public SuggestionServiceImpl(SuggestionRepository repo) {
        this.repo = repo;
    }

    @Override
    public Suggestion generate(String crop) {
        return repo.save(Suggestion.builder()
                .crop(crop)
                .fertilizer("NPK")
                .build());
    }
}
