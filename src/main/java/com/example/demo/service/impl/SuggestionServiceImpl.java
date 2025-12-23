package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private final FarmRepository farmRepository;
    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;
    private final SuggestionRepository suggestionRepository;

    public SuggestionServiceImpl(FarmRepository farmRepository,
                                 CropRepository cropRepository,
                                 FertilizerRepository fertilizerRepository,
                                 SuggestionRepository suggestionRepository) {
        this.farmRepository = farmRepository;
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
        this.suggestionRepository = suggestionRepository;
    }

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        Farm farm = farmRepository.findById(farmId)
                .orElseThrow(() -> new RuntimeException("Farm not found"));

        List<Crop> crops = cropRepository.findSuitableCrops(
                farm.getSoilPH(),
                farm.getWaterLevel(),
                farm.getSeason()
        );

        List<Fertilizer> fertilizers = crops.stream()
                .flatMap(c -> fertilizerRepository
                        .findByRecommendedForCropsContaining(c.getName())
                        .stream())
                .distinct()
                .toList();

        Suggestion suggestion = new Suggestion();
        suggestion.setFarm(farm);
        suggestion.setSuggestedCrops(
                crops.stream().map(Crop::getName).collect(Collectors.joining(","))
        );
        suggestion.setSuggestedFertilizers(
                fertilizers.stream().map(Fertilizer::getName).collect(Collectors.joining(","))
        );

        return suggestionRepository.save(suggestion);
    }

    @Override
    public Suggestion getSuggestion(Long suggestionId) {
        return suggestionRepository.findById(suggestionId)
                .orElseThrow(() -> new RuntimeException("Suggestion not found"));
    }

    @Override
    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        return suggestionRepository.findByFarmId(farmId);
    }
}
