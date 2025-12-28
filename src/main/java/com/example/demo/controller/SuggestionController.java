package com.example.demo.controller;

import com.example.demo.dto.SuggestionResponse;
import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suggestion")
public class SuggestionController {

    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @PostMapping("/{id}")
    public SuggestionResponse generate(long id) {
        Suggestion s = suggestionService.generate(id);
        return new SuggestionResponse();
    }

    @GetMapping("/{id}")
    public SuggestionResponse getSuggestion(long id) {
        return new SuggestionResponse();
    }
}
