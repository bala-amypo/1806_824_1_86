package com.example.demo.service.impl;

import com.example.demo.dto.SuggestionResponse;
import com.example.demo.entity.Farm;
import com.example.demo.repository.FarmRepository;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private final FarmRepository farmRepository;

    public SuggestionServiceImpl(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @Override
    public SuggestionResponse getSuggestion(Long farmId) {

        Farm farm = farmRepository.findById(farmId)
                .orElseThrow(() -> new RuntimeException("Farm not found"));

        return new SuggestionResponse(
                1L,
                "Rice",
                "Urea",
                "46-0-0"
        );
    }
}
