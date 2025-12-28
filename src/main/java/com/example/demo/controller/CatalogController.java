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

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    // ================= CROPS =================

    @GetMapping("/crops/{season}")
    public List<Crop> getCropsBySeason(@PathVariable String season) {
        return catalogService.getCropsBySeason(season);
    }

    // ================= FERTILIZERS =================

    @GetMapping("/fertilizers/{cropName}")
    public List<Fertilizer> getFertilizersForCrop(
            @PathVariable String cropName) {

        return catalogService.getFertilizersForCrop(cropName);
    }
}
