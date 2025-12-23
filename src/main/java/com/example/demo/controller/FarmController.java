package com.example.demo.controller;

import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
public class FarmController {

    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    // POST /farms
    @PostMapping
    public Farm createFarm(@RequestBody Farm farm) {
        Long userId = 1L; // TEMP USER ID (NO SECURITY)
        return farmService.createFarm(farm, userId);
    }

    // GET /farms
    @GetMapping
    public List<Farm> listFarms() {
        Long userId = 1L; // TEMP USER ID
        return farmService.getFarmsByOwner(userId);
    }

    // GET /farms/{id}
    @GetMapping("/{id}")
    public Farm getFarm(@PathVariable Long id) {
        return farmService.getFarmById(id);
    }
}
