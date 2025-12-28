package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Override
    public Crop addCrop(Crop crop) {
        return crop;
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        return fertilizer;
    }

    @Override
    public List<Crop> findSuitableCrops(double soilPh, String season) {
        return new ArrayList<>();
    }

    @Override
    public List<Crop> findSuitableCrops(double minPh, double maxPh, String season) {
        return new ArrayList<>();
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        return new ArrayList<>();
    }
}
