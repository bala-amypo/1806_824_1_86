package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor 
@NoArgsConstructor 
@Data
public class FarmRequest {
    private String name;
    private double soilPH;
    private double waterLevel;
    private String season;
}
