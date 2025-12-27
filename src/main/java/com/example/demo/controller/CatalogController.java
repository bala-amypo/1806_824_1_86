package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService service;

    public CatalogController(CatalogService service) {
        this.service = service;
    }

    @GetMapping("/crops")
    public ResponseEntity<List<Crop>> findCrops(double water, String season) {
        return ResponseEntity.ok(service.findCrops(water, season));
    }

    @GetMapping("/fertilizers")
    public ResponseEntity<List<Fertilizer>> findFerts(String crop) {
        return ResponseEntity.ok(service.findFertilizers(crop));
    }
}
