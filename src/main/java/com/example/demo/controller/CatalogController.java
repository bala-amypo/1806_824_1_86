package com.example.demo.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/catalog")
@Tag(name = "Catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    // ADMIN
    @Operation(summary = "Add crop (ADMIN)")
    @PostMapping("/crop")
    public Crop addCrop(@RequestBody CropRequest req, Authentication auth) {
        return catalogService.addCrop(req, auth);
    }

    // ADMIN
    @Operation(summary = "Add fertilizer (ADMIN)")
    @PostMapping("/fertilizer")
    public Fertilizer addFertilizer(@RequestBody FertilizerRequest req, Authentication auth) {
        return catalogService.addFertilizer(req, auth);
    }

    @Operation(summary = "Get suitable crops")
    @GetMapping("/crops/suitable")
    public List<Crop> suitableCrops(
            @RequestParam double ph,
            @RequestParam String water,
            @RequestParam String season) {

        return catalogService.findSuitableCrops(ph, water, season);
    }

    @Operation(summary = "Get fertilizers by crop")
    @GetMapping("/fertilizers/by-crop")
    public List<Fertilizer> fertilizersByCrop(@RequestParam String name) {
        return catalogService.findFertilizersByCrop(name);
    }
}
