package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepo;
    private final FertilizerRepository fertRepo;

    @Override
    public Crop addCrop(Crop crop) {
        return cropRepo.save(crop);
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        return fertRepo.save(fertilizer);
    }

    @Override
    public List<Crop> findSuitableCrops(double soilPH, double water, String season) {
        return cropRepo.findSuitableCrops(soilPH, water, season);
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> crops) {
        List<Fertilizer> result = new ArrayList<>();
        for (String crop : crops) {
            result.addAll(fertRepo.findByRecommendedForCropsContaining(crop));
        }
        return result;
    }
}
