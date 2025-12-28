package com.example.demo.service.impl;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepo;
    private final FertilizerRepository fertRepo;

    public CatalogServiceImpl(CropRepository cropRepo, FertilizerRepository fertRepo) {
        this.cropRepo = cropRepo;
        this.fertRepo = fertRepo;
    }

    @Override
    public Crop addCrop(CropRequest r) {
        Crop c = new Crop();
        return cropRepo.save(c);
    }

    @Override
    public Fertilizer addFertilizer(FertilizerRequest r) {
        Fertilizer f = new Fertilizer();
        return fertRepo.save(f);
    }

    @Override
    public List<Crop> findCrops(double minPh, double maxPh, String season) {
        return cropRepo.findAll();
    }

    @Override
    public List<Fertilizer> findFerts(String cropName) {
        return fertRepo.findAll();
    }
}
