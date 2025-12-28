package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/crop")
    public Crop addCrop(@RequestBody CropRequest req) {
        Crop crop = new Crop();
        crop.setName(req.getName());
        crop.setSeason(req.getSeason());
        crop.setSoilPH(req.getSoilPH());
        return catalogService.saveCrop(crop);
    }

    @PostMapping("/fertilizer")
    public Fertilizer addFertilizer(@RequestBody FertilizerRequest req) {
        Fertilizer f = new Fertilizer();
        f.setName(req.getName());
        f.setNpkRatio(req.getNpkRatio());
        f.setRecommendedForCrops(req.getRecommendedForCrops());
        return catalogService.saveFertilizer(f);
    }

    @GetMapping("/crops")
    public List<Crop> findCrops(
            @RequestParam double minPh,
            @RequestParam double maxPh,
            @RequestParam String season) {
        return catalogService.findCrops(minPh, maxPh, season);
    }

    @GetMapping("/fertilizers")
    public List<Fertilizer> findFerts(@RequestParam String crop) {
        return catalogService.findFerts(crop);
    }
}
