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

    private final FarmService service;

    public FarmController(FarmService service) {
        this.service = service;
    }

    @PostMapping
    public Farm createFarm(@RequestBody FarmRequest req, Authentication auth) {
        return service.createFarm(req, Long.parseLong(auth.getName()));
    }

    @GetMapping
    public List<Farm> listFarms(Authentication auth) {
        return service.getFarmsByOwner(Long.parseLong(auth.getName()));
    }
}
