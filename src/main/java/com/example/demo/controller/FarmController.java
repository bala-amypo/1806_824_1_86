package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/farms")
public class FarmController {

    private final FarmService farmService;

    @PostMapping
    public ResponseEntity<Farm> createFarm(@RequestBody FarmRequest req) {

        Farm farm = Farm.builder()
                .name(req.getName())
                .soilPH(req.getSoilPH())
                .waterLevel(req.getWaterLevel())
                .season(req.getSeason())
                .build();

        return ResponseEntity.ok(farmService.createFarm(farm));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farm> getFarm(@PathVariable long id) {
        return ResponseEntity.ok(farmService.getFarmById(id));
    }

    @GetMapping
    public ResponseEntity<List<Farm>> getAllFarms() {
        return ResponseEntity.ok(farmService.getAllFarms());
    }
}
