package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {

    void addCrop(Crop crop);
    void addFertilizer(Fertilizer fertilizer);

    List<Crop> findSuitableCrops(double soilPH, String season);
    List<Crop> findSuitableCrops(double soilPH, double water, String season);

    List<Fertilizer> findFertilizersForCrops(List<String> cropNames);
}
