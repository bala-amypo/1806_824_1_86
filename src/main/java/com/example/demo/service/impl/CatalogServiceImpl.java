package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepo;
    private final FertilizerRepository fertRepo;

    public CatalogServiceImpl(CropRepository cropRepo, FertilizerRepository fertRepo) {
        this.cropRepo = cropRepo;
        this.fertRepo = fertRepo;
    }

    @Override
    public List<Crop> findCrops(double water, String season) {
        return cropRepo.findSuitableCrops(water, season);
    }

    @Override
    public List<Fertilizer> findFertilizers(String crop) {
        return fertRepo.findByRecommendedForCrops(crop);
    }
}
