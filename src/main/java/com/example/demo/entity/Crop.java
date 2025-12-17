package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Entity
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Double suitablePHMin;
    private Double suitablePHMax;
    private Double requiredWater;

    @Column(nullable = false)
    private String season;

    public Crop() {
    }

    @PrePersist
    @PreUpdate
    private void validate() {
        if (suitablePHMin > suitablePHMax) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "PH min must be <= PH max"
            );
        }

        if (!season.equals("Kharif")
                && !season.equals("Rabi")
                && !season.equals("Summer")) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Invalid season"
            );
        }
    }

    // Getters & Setters
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
