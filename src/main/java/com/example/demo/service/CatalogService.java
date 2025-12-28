package com.example.demo.service;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {

    Crop addCrop(CropRequest request);

    Fertilizer addFertilizer(FertilizerRequest request);

    List<Crop> findCrops(double minPh, double maxPh, String season);

    List<Fertilizer> findFerts(String cropName);
}
