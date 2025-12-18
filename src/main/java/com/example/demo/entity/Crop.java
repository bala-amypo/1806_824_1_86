package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import org.springframework.web.server.BadRequestException;

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

    public Crop(Long id, String name, Double suitablePHMin, Double suitablePHMax, Double requiredWater, String season) {
        this.id = id;
        this.name = name;
        this.suitablePHMin = suitablePHMin;
        this.suitablePHMax = suitablePHMax;
        this.requiredWater = requiredWater;
        this.season = season;
    }

    @PrePersist
    @PreUpdate
    public void validateCrop() {

        if (suitablePHMin > suitablePHMax) {
            throw new BadRequestException("PH min");
        }

        if (!season.equalsIgnoreCase("Kharif")
                && !season.equalsIgnoreCase("Rabi")
                && !season.equalsIgnoreCase("Summer")) {
            throw new BadRequestException("Invalid season");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSuitablePHMin() {
        return suitablePHMin;
    }

    public void setSuitablePHMin(Double suitablePHMin) {
        this.suitablePHMin = suitablePHMin;
    }

    public Double getSuitablePHMax() {
        return suitablePHMax;
    }

    public void setSuitablePHMax(Double suitablePHMax) {
        this.suitablePHMax = suitablePHMax;
    }

    public Double getRequiredWater() {
        return requiredWater;
    }

    public void setRequiredWater(Double requiredWater) {
        this.requiredWater = requiredWater;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
