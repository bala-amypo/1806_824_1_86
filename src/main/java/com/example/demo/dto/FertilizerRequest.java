package com.example.demo.dto;

import lombok.Data;

@Data
public class FertilizerRequest {
    private String name;
    private String npkRatio;
    private String recommendedForCrops;
}
