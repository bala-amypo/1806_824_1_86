package com.example.demo.dto;

import lombok.Data;

@Data
public class CropRequest {
    private String cropName;
    private String soilType;
    private String season;
}
