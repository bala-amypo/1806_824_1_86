package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/farms")
public class FarmController {

    private final FarmService farmService;

    // ✅ Constructor injection (NO @Autowired needed)
    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    // ✅ Create Farm
    @PostMapping
    public Farm createFarm(@RequestBody FarmRequest req) {

        Farm farm = new Farm();
        farm.setName(req.getName());
        farm.setSoilPH(req.getSoilPH());
        farm.setSeason(req.getSeason());

        return farmService.saveFarm(farm);
    }
}
