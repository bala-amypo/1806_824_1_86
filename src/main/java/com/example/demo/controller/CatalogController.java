package com.example.demo.controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    @GetMapping
    public ResponseEntity<List<String>> getCatalog() {
        List<String> items = Arrays.asList("Laptop", "Phone", "Tablet");
        return ResponseEntity.ok(items);
    }
}
