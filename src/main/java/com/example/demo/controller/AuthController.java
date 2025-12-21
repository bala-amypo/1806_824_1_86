package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
public class FarmController {

    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @PostMapping
    public Farm createFarm(@RequestBody FarmRequest request,
                           Authentication authentication) {

        Long ownerId = (Long) authentication.getPrincipal();

        Farm farm = Farm.builder()
                .name(request.getName())
                .soilPH(request.getSoilPH())
                .waterLevel(request.getWaterLevel())
                .season(request.getSeason())
                .build();

        return farmService.createFarm(farm, ownerId);
    }

    @GetMapping
    public List<Farm> listFarms(Authentication authentication) {
        Long ownerId = (Long) authentication.getPrincipal();
        return farmService.getFarmsByOwner(ownerId);
    }

    @GetMapping("/{farmId}")
    public Farm getFarm(@PathVariable Long farmId) {
        return farmService.getFarmById(farmId);
    }
}
