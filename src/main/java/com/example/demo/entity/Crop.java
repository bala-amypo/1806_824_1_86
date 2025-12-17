package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    public Crop() {
    }

    public Crop(Long id, String name, Double suitablePHMin, Double suitablePHMax,
                Double requiredWater, String season) {
        this.id = id;
        this.name = name;
        this.suitablePHMin = suitablePHMin;
        this.suitablePHMax = suitablePHMax;
        this.requiredWater = requiredWater;
        this.season = season;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSuitablePHMin() {
        return suitablePHMin;
    }

    public Double getSuitablePHMax() {
        return suitablePHMax;
    }

    public Double getRequiredWater() {
        return requiredWater;
    }

    public String getSeason() {
        return season;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuitablePHMin(Double suitablePHMin) {
        this.suitablePHMin = suitablePHMin;
    }

    public void setSuitablePHMax(Double suitablePHMax) {
        this.suitablePHMax = suitablePHMax;
    }

    public void setRequiredWater(Double requiredWater) {
        this.requiredWater = requiredWater;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
