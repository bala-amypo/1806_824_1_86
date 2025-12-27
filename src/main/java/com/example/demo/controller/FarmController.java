package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;
    private final UserService userService; // REQUIRED by tests

    @PostMapping("/farms")
    public ResponseEntity<Farm> createFarm(
            @RequestBody FarmRequest req,
            Authentication auth
    ) {
        Farm farm = Farm.builder()
                .name(req.getName())
                .soilPH(req.getSoilPH())
                .waterLevel(req.getWaterLevel())
                .season(req.getSeason())
                .build();

        return ResponseEntity.ok(farmService.createFarm(farm));
    }

    @GetMapping("/farms")
    public ResponseEntity<List<Farm>> listFarms(Authentication auth) {
        return ResponseEntity.ok(farmService.getAllFarms());
    }
}
