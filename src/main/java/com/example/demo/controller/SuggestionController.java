package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/suggestions")
@Tag(name = "Suggestions")
public class SuggestionController {

    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @Operation(summary = "Generate suggestion")
    @PostMapping("/{farmId}")
    public Suggestion generate(@PathVariable Long farmId) {
        return suggestionService.generateSuggestion(farmId);
    }

    @Operation(summary = "Get suggestion")
    @GetMapping("/{suggestionId}")
    public Suggestion get(@PathVariable Long suggestionId) {
        return suggestionService.getSuggestion(suggestionId);
    }

    @Operation(summary = "List farm suggestions")
    @GetMapping("/farm/{farmId}")
    public List<Suggestion> list(@PathVariable Long farmId) {
        return suggestionService.listFarmSuggestions(farmId);
    }
}
