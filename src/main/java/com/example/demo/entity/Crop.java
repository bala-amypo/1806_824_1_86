package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

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

    @PrePersist
    @PreUpdate
    public void validateCrop() {

        if (suitablePHMin > suitablePHMax) {
            throw new IllegalArgumentException("PH min");
        }

        if (!season.equalsIgnoreCase("Kharif")
                && !season.equalsIgnoreCase("Rabi")
                && !season.equalsIgnoreCase("Summer")) {
            throw new IllegalArgumentException("Invalid season");
        }
    }

    // getters & setters omitted for brevity (keep yours)
}
