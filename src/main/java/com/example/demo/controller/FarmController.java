package com.example.demo.controller;

import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
public class FarmController {

    private final FarmService farmService;

    // Constructor injection
    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    // POST /farms
    @PostMapping
    public Farm createFarm(@RequestBody Farm farm, Authentication authentication) {
        Long userId = Long.parseLong(authentication.getName());
        return farmService.createFarm(farm, userId);
    }

    // GET /farms
    @GetMapping
    public List<Farm> listFarms(Authentication authentication) {
        Long userId = Long.parseLong(authentication.getName());
        return farmService.getFarmsByOwner(userId);
    }

    // GET /farms/{farmId}
    @GetMapping("/{farmId}")
    public Farm getFarm(@PathVariable Long farmId) {
        return farmService.getFarmById(farmId);
    }
}
