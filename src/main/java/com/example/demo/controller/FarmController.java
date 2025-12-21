package com.example.demo.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/farms")
@Tag(name = "Farms")
public class FarmController {

    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    // POST /farms
    @Operation(summary = "Add new farm")
    @PostMapping
    public Farm createFarm(@RequestBody FarmRequest req, Authentication auth) {
        return farmService.createFarm(req, auth);
    }

    // GET /farms
    @Operation(summary = "List user farms")
    @GetMapping
    public List<Farm> listFarms(Authentication auth) {
        return farmService.listFarms(auth);
    }

    // GET /farms/{farmId}
    @Operation(summary = "Get farm details")
    @GetMapping("/{farmId}")
    public Farm getFarm(@PathVariable Long farmId) {
        return farmService.getFarm(farmId);
    }
}
