package com.example.demo.controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {

    @GetMapping
    public ResponseEntity<List<String>> getSuggestions(
            @RequestParam String query) {

        List<String> suggestions = Arrays.asList(
                query + " 1",
                query + " 2",
                query + " 3"
        );

        return ResponseEntity.ok(suggestions);
    }
}
