package com.example.demo.dto;

import lombok.Data;

@Data
public class CropRequest {
    private String name;
    private double suitablePHMin;
    private double suitablePHMax;
    private double requiredWater;
    private String season;
}
