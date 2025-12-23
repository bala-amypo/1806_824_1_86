package com.example.demo.controller;

import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
@RequiredArgsConstructor
public class FarmController {

    private final FarmService service;

    @PostMapping
    public Farm createFarm(@RequestBody Farm farm, Authentication auth) {
        Long userId = Long.parseLong(auth.getName());
        return service.createFarm(farm, userId);
    }

    @GetMapping
    public List<Farm> list(Authentication auth) {
        Long userId = Long.parseLong(auth.getName());
        return service.getFarmsByOwner(userId);
    }

    @GetMapping("/{id}")
    public Farm get(@PathVariable Long id) {
        return service.getFarmById(id);
    }
}
