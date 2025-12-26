package com.example.demo.dto;

@AllArgsConstructor @NoArgsConstructor @Data
public class CropRequest {
    private String name;
    private double minPH;
    private double maxPH;
    private double water;
    private String season;
}
