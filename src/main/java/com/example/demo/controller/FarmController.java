package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/farms")
@RequiredArgsConstructor
public class FarmController {

    private final FarmServiceImpl farmService;

    @PostMapping
    public ResponseEntity<?> createFarm(
            @RequestBody FarmRequest req,
            Authentication auth) {

        return ResponseEntity.ok(farmService.createFarm(req, auth));
    }

    @GetMapping
    public ResponseEntity<?> listFarms(Authentication auth) {
        return ResponseEntity.ok(farmService.listFarms(auth));
    }
}
