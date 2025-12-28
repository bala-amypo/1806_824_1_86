package com.example.demo.dto;

public class FarmRequest {

    private String name;
    private double soilPH;
    private String waterLevel;
    private String season;

    public String getName() {
        return name;
    }

    public double getSoilPH() {
        return soilPH;
    }

    public String getWaterLevel() {
        return waterLevel;
    }

    public String getSeason() {
        return season;
    }
}
