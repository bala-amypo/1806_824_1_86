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

    private final CropRepository cropRepo;
    private final FertilizerRepository fertRepo;

    public CatalogServiceImpl(CropRepository c, FertilizerRepository f){
        this.cropRepo=c; this.fertRepo=f;
    }

    public Crop addCrop(Crop c){ return cropRepo.save(c); }
    public Fertilizer addFertilizer(Fertilizer f){ return fertRepo.save(f); }

    public List<Crop> findSuitableCrops(Double ph, Double water, String season){
        return cropRepo.findSuitableCrops(ph,water,season);
    }

    public List<Fertilizer> findFertilizersForCrops(List<String> crops){
        if(crops==null||crops.isEmpty()) return List.of();
        return fertRepo.findByCropName(crops.get(0));
    }
}
