package com.example.demo.dto;

@AllArgsConstructor 
@NoArgsConstructor 
@Data
public class FarmRequest {
    private String name;
    private double soilPH;
    private double waterLevel;
    private String season;
}
