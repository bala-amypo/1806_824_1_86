package com.example.demo.service.impl;

import com.example.demo.dto.SuggestionResponse;
import com.example.demo.entity.Farm;
import com.example.demo.entity.Fertilizer;
import com.example.demo.entity.Crop;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private final FarmRepository farmRepository;
    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    public SuggestionServiceImpl(
            FarmRepository farmRepository,
            CropRepository cropRepository,
            FertilizerRepository fertilizerRepository) {

        this.farmRepository = farmRepository;
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    @Override
    public SuggestionResponse getSuggestion(Long farmId) {

        Farm farm = farmRepository.findById(farmId)
                .orElseThrow(() -> new RuntimeException("Farm not found"));

        Crop crop = cropRepository.findSuitableCrop(
                farm.getSoilPH(),
                farm.getWaterLevel(),
                farm.getSeason()
        );

        Fertilizer fertilizer =
                fertilizerRepository.findBestForCrop(crop.getName());

        return new SuggestionResponse(
                crop.getName(),
                fertilizer.getName(),
                fertilizer.getNpkRatio()
        );
    }
}
