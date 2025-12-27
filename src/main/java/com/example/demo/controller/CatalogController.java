package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addCrop(@RequestBody CropRequest req, Authentication auth) {
        Crop crop = Crop.builder()
                .name(req.getName())
                .suitablePHMin(req.getSuitablePHMin())
                .suitablePHMax(req.getSuitablePHMax())
                .requiredWater(req.getRequiredWater())
                .season(req.getSeason())
                .build();
        return ResponseEntity.ok(catalogService.addCrop(crop));
    }

    @PostMapping("/fertilizer")
    public ResponseEntity<?> addFertilizer(@RequestBody FertilizerRequest req, Authentication auth) {
        Fertilizer fert = Fertilizer.builder()
                .name(req.getName())
                .npkRatio(req.getNpkRatio())
                .recommendedForCrops(req.getRecommendedForCrops())
                .build();
        return ResponseEntity.ok(catalogService.addFertilizer(fert));
    }

    @GetMapping("/crops/suitable")
    public List<Crop> findCrops(
            @RequestParam Double ph,
            @RequestParam Double water,
            @RequestParam String season
    ) {
        return catalogService.findSuitableCrops(ph, water, season);
    }

    @GetMapping("/fertilizers/by-crop")
    public List<Fertilizer> findFerts(@RequestParam String name) {
        return catalogService.findFertilizersForCrops(List.of(name));
    }
}
