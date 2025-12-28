package com.example.demo.controller;

import com.example.demo.dto.SuggestionResponse;
import com.example.demo.service.SuggestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {

    private final SuggestionService service;

    public SuggestionController(SuggestionService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public SuggestionResponse getSuggestion(@PathVariable Long id) {
        return service.generateSuggestion(id);
    }
}
