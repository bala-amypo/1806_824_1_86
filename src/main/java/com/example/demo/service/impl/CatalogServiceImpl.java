package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    public CatalogServiceImpl(CropRepository cropRepository,
                              FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    // ---------------- ADD CROP ----------------
    @Override
    public Crop addCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    // ---------------- ADD FERTILIZER ----------------
    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        return fertilizerRepository.save(fertilizer);
    }

    // ---------------- FIND SUITABLE CROPS ----------------
    @Override
    public List<Crop> findSuitableCrops(double soilPh, String season) {
        return cropRepository.findBySeason(season)
                .stream()
                .filter(crop ->
                        soilPh >= crop.getMinSoilPh() &&
                        soilPh <= crop.getMaxSoilPh()
                )
                .toList();
    }

    // ---------------- FIND FERTILIZERS FOR CROPS ----------------
    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        return cropNames.stream()
                .flatMap(name -> fertilizerRepository.findByCrop(name).stream())
                .toList();
    }
}
