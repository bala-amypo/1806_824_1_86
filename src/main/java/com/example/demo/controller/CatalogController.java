package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/crop")
    public void addCrop(CropRequest req, Authentication auth) {
        Crop crop = new Crop();
        catalogService.addCrop(crop);
    }

    @PostMapping("/fertilizer")
    public void addFertilizer(FertilizerRequest req, Authentication auth) {
        Fertilizer fert = new Fertilizer();
        catalogService.addFertilizer(fert);
    }

    public List<Crop> findCrops(double soil, double water, String season) {
        return catalogService.findSuitableCrops(soil, water, season);
    }

    public List<Fertilizer> findFerts(String crop) {
        return catalogService.findFertilizersForCrops(List.of(crop));
    }
}
