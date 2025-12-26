package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Crop;

public interface CatalogService {

    Crop addCrop(Crop crop);

    Fertilizer addFertilizer(Fertilizer fertilizer);

    List<Crop> findSuitableCrops(double soilPh, double rainfall, String season);

    List<Fertilizer> findFertilizersForCrops(List<String> crops);
}
