package com.example.demo.controller;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService service;

    @PostMapping("/crop")
    public Crop addCrop(@RequestBody Crop crop) {
        return service.addCrop(crop);
    }

    @PostMapping("/fertilizer")
    public Fertilizer addFertilizer(@RequestBody Fertilizer fertilizer) {
        return service.addFertilizer(fertilizer);
    }

    @GetMapping("/crops/suitable")
    public List<Crop> suitable(@RequestParam Double ph,
                               @RequestParam Double water,
                               @RequestParam String season) {
        return service.findSuitableCrops(ph, water, season);
    }

    @GetMapping("/fertilizers/by-crop")
    public List<Fertilizer> byCrop(@RequestParam List<String> name) {
        return service.findFertilizersForCrops(name);
    }
}
