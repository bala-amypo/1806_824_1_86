package com.example.demo.controller;

import com.example.demo.dto.SuggestionResponse;
import com.example.demo.service.SuggestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {

    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @GetMapping("/{farmId}")
    public ResponseEntity<SuggestionResponse> getSuggestion(
            @PathVariable Long farmId) {

        SuggestionResponse response =
                suggestionService.getSuggestion(farmId);

        return ResponseEntity.ok(response);
    }
}
