package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final List<Crop> crops = new ArrayList<>();
    private final List<Fertilizer> fertilizers = new ArrayList<>();

    @Override
    public void addCrop(Crop crop) {
        crops.add(crop);
    }

    @Override
    public void addFertilizer(Fertilizer fertilizer) {
        fertilizers.add(fertilizer);
    }

    @Override
    public List<Crop> findSuitableCrops(double soilPH, String season) {
        return crops;
    }

    @Override
    public List<Crop> findSuitableCrops(double soilPH, double water, String season) {
        return crops;
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        return fertilizers;
    }
}
