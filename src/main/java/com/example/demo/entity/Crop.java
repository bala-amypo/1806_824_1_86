package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double suitablePHMin;
    private Double suitablePHMax;

    private Double requiredWater;

    private String season;

    // getters and setters for all fields
    public Double getSuitablePHMin() { return suitablePHMin; }
    public void setSuitablePHMin(Double suitablePHMin) { this.suitablePHMin = suitablePHMin; }

    public Double getSuitablePHMax() { return suitablePHMax; }
    public void setSuitablePHMax(Double suitablePHMax) { this.suitablePHMax = suitablePHMax; }

    public Double getRequiredWater() { return requiredWater; }
    public void setRequiredWater(Double requiredWater) { this.requiredWater = requiredWater; }

    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }

    // name getter/setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
