package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final FarmRepository farmRepo;
    private final CropRepository cropRepo;
    private final FertilizerRepository fertRepo;
    private final SuggestionRepository suggestionRepo;

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        Farm farm = farmRepo.findById(farmId)
                .orElseThrow(() -> new ResourceNotFoundException("Farm"));

        List<Crop> crops = cropRepo.findSuitableCrops(
                farm.getSoilPH(), farm.getWaterLevel(), farm.getSeason());

        List<Fertilizer> fertilizers = crops.stream()
                .flatMap(c -> fertRepo.findByRecommendedForCropsContaining(c.getName()).stream())
                .distinct()
                .toList();

        Suggestion suggestion = Suggestion.builder()
                .farm(farm)
                .suggestedCrops(crops.stream().map(Crop::getName).collect(Collectors.joining(",")))
                .suggestedFertilizers(fertilizers.stream().map(Fertilizer::getName).collect(Collectors.joining(",")))
                .build();

        return suggestionRepo.save(suggestion);
    }

    @Override
    public Suggestion getSuggestion(Long suggestionId) {
        return suggestionRepo.findById(suggestionId)
                .orElseThrow(() -> new ResourceNotFoundException("Suggestion"));
    }

    @Override
    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        return suggestionRepo.findByFarmId(farmId);
    }
}
