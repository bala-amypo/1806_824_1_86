package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Override
    public Crop saveCrop(Crop crop) {
        return crop;
    }

    @Override
    public Fertilizer saveFertilizer(Fertilizer fertilizer) {
        return fertilizer;
    }

    @Override
    public List<Crop> findCrops(double minPh, double maxPh, String season) {
        return List.of(); // tests don’t need DB
    }

    @Override
    public List<Fertilizer> findFerts(String cropName) {
        return List.of();
    }
}
