package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Farm;
import com.example.demo.entity.Fertilizer;
import com.example.demo.entity.Suggestion;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.repository.SuggestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuggestionService {

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;
    private final SuggestionRepository suggestionRepository;

    public SuggestionService(CropRepository cropRepository,
                             FertilizerRepository fertilizerRepository,
                             SuggestionRepository suggestionRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
        this.suggestionRepository = suggestionRepository;
    }

    public Suggestion generateSuggestion(Farm farm) {

        List<Crop> crops = cropRepository.findAll();
        List<Fertilizer> fertilizers = fertilizerRepository.findAll();

        String cropNames = crops.stream()
                .filter(c -> c.getSeason().equalsIgnoreCase(farm.getSeason()))
                .filter(c -> farm.getSoilPH() >= c.getSuitablePHMin()
                          && farm.getSoilPH() <= c.getSuitablePHMax())
                .map(Crop::getName)
                .collect(Collectors.joining(", "));

        String fertilizerNames = fertilizers.stream()
                .map(Fertilizer::getName)
                .collect(Collectors.joining(", "));

        Suggestion suggestion = new Suggestion();
        suggestion.setFarm(farm);
        suggestion.setSuggestedCrops(cropNames);
        suggestion.setSuggestedFertilizers(fertilizerNames);

        return suggestionRepository.save(suggestion);
    }
}
