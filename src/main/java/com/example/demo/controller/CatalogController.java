package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @PostMapping("/crops")
    public ResponseEntity<Crop> addCrop(
            @RequestBody CropRequest req,
            Authentication auth
    ) {
        Crop crop = Crop.builder()
                .name(req.getName())
                .suitablePHMin(req.getSuitablePHMin())
                .suitablePHMax(req.getSuitablePHMax())
                .requiredWater(req.getRequiredWater())
                .season(req.getSeason())
                .build();

        return ResponseEntity.ok(catalogService.addCrop(crop));
    }

    @PostMapping("/fertilizers")
    public ResponseEntity<Fertilizer> addFertilizer(
            @RequestBody FertilizerRequest req,
            Authentication auth
    ) {
        Fertilizer f = Fertilizer.builder()
                .name(req.getName())
                .npkRatio(req.getNpkRatio())
                .cropName(req.getCropName())
                .build();

        return ResponseEntity.ok(catalogService.addFertilizer(f));
    }
}
