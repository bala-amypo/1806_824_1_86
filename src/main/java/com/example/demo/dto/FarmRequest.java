package com.example.demo.dto;

import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmRequest {
    private String name;
    private double soilPH;
    private double waterLevel;
    private String season;
}
