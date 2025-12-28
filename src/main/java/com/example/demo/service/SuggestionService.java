package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {

    List<Crop> getCropsBySeason(String season);

    List<Fertilizer> getFertilizersForCrop(String cropName);
}
