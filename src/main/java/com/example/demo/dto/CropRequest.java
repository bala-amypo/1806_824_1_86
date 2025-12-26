package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class CropRequest {
    private String name;
    private double minPH;
    private double maxPH;
    private double water;
    private String season;
}
