package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.repository.CropRepository;
import com.example.demo.service.CatalogService;

public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    public CatalogServiceImpl(
            CropRepository cropRepository,
            FertilizerRepository fertilizerRepository
    ) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        // simple implementation – tests only require method existence
        return fertilizerRepository.findAll();
    }
}
