package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    public CatalogServiceImpl(CropRepository cropRepository,
                              FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    // ================= CROPS =================

    @Override
    public List<Crop> getCropsBySeason(String season) {
        return cropRepository.findBySeason(season);
    }

    // ================= FERTILIZERS =================

    @Override
    public List<Fertilizer> getFertilizersForCrop(String cropName) {
        return fertilizerRepository
                .findByRecommendedForCropsContaining(cropName);
    }
}
