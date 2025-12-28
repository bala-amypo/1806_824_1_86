package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

public interface CatalogService {

    Crop saveCrop(Crop crop);

    Fertilizer saveFertilizer(Fertilizer fertilizer);

    List<Crop> findCrops(double minPh, double maxPh, String season);

    List<Fertilizer> findFerts(String cropName);
}
