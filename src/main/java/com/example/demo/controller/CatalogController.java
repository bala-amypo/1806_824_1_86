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
    public Crop addCrop(CropRequest req, Authentication auth) {
        return catalogService.addCrop(req);
    }

    @PostMapping("/fertilizer")
    public Fertilizer addFertilizer(FertilizerRequest req, Authentication auth) {
        return catalogService.addFertilizer(req);
    }

    @GetMapping("/crops")
    public List<Crop> findCrops(double minPh, double maxPh, String season) {
        return catalogService.findCrops(minPh, maxPh, season);
    }

    @GetMapping("/fertilizers")
    public List<Fertilizer> findFerts(String cropName) {
        return catalogService.findFerts(cropName);
    }
}
