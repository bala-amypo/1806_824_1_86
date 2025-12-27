package com.example.demo.service.impl;

import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
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

    // implement ALL methods declared in CatalogService
}
