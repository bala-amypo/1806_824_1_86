package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/farm")
public class FarmController {

    @GetMapping("/{id}")
    public ResponseEntity<String> getFarmById(@PathVariable int id) {
        return ResponseEntity.ok("Farm ID: " + id);
    }
}
