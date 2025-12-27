package com.example.demo.controller;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/suggestions")
public class SuggestionController {

    private final SuggestionService service;

    @PostMapping("/{farmId}")
    public ResponseEntity<Suggestion> generate(@PathVariable long farmId) {
        return ResponseEntity.ok(service.generateSuggestion(farmId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suggestion> get(@PathVariable long id) {
        return ResponseEntity.ok(service.getSuggestion(id));
    }
}
