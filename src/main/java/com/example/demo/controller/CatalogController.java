package com.example.demo.controller;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    // Constructor injection
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    // ADMIN: Add Crop
    @PostMapping("/crop")
    public Crop addCrop(@RequestBody Crop crop) {
        return catalogService.addCrop(crop);
    }

    // ADMIN: Add Fertilizer
    @PostMapping("/fertilizer")
    public Fertilizer addFertilizer(@RequestBody Fertilizer fertilizer) {
        return catalogService.addFertilizer(fertilizer);
    }

    // GET suitable crops
    @GetMapping("/crops/suitable")
    public List<Crop> getSuitableCrops(
            @RequestParam Double ph,
            @RequestParam Double water,
            @RequestParam String season) {

        return catalogService.findSuitableCrops(ph, water, season);
    }

    // GET fertilizers by crop name
    @GetMapping("/fertilizers/by-crop")
    public List<Fertilizer> getFertilizersByCrop(
            @RequestParam List<String> name) {

        return catalogService.findFertilizersForCrops(name);
    }
}
