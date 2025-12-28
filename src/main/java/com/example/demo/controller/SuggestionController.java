package com.example.demo.controller;

import com.example.demo.dto.SuggestionResponse;
import com.example.demo.service.SuggestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suggestion")
public class SuggestionController {

    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @GetMapping("/{farmId}")
    public SuggestionResponse generate(@PathVariable Long farmId) {
        return suggestionService.getSuggestion(farmId);
    }
}
