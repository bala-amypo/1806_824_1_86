package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {
    List<Crop> findCrops(double water, String season);
    List<Fertilizer> findFertilizers(String crop);
}
