package com.example.demo.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

@Service
public class CatalogService {

    public Crop addCrop(CropRequest req, Authentication auth) {
        return new Crop();
    }

    public Fertilizer addFertilizer(FertilizerRequest req, Authentication auth) {
        return new Fertilizer();
    }

    public List<Crop> findSuitableCrops(double ph, String water, String season) {
        return List.of();
    }

    public List<Fertilizer> findFertilizersByCrop(String name) {
        return List.of();
    }
}
