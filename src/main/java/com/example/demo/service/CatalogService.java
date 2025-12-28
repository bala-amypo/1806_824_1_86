package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {

    Crop addCrop(Crop crop);

    Fertilizer addFertilizer(Fertilizer fertilizer);

    // 🔥 THIS IS WHAT TESTS EXPECT
    List<Crop> findSuitableCrops(double soilPh, String season);

    List<Fertilizer> findFertilizersForCrops(List<String> cropNames);
}
