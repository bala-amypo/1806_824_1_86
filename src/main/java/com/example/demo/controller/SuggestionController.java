package com.example.demo.controller;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {

    private final SuggestionService suggestionService;

    // Constructor injection
    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    // POST /suggestions/{farmId}
    @PostMapping("/{farmId}")
    public Suggestion generateSuggestion(@PathVariable Long farmId) {
        return suggestionService.generateSuggestion(farmId);
    }

    // GET /suggestions/{suggestionId}
    @GetMapping("/{suggestionId}")
    public Suggestion getSuggestion(@PathVariable Long suggestionId) {
        return suggestionService.getSuggestion(suggestionId);
    }

    // GET /suggestions/farm/{farmId}
    @GetMapping("/farm/{farmId}")
    public List<Suggestion> getSuggestionsByFarm(@PathVariable Long farmId) {
        return suggestionService.getSuggestionsByFarm(farmId);
    }
}
