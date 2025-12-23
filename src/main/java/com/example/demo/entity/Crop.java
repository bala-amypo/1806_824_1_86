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

   
    public Crop() {}

    public Crop(Long id, String name, Double suitablePHMin, Double suitablePHMax,
                Double requiredWater, String season) {
        this.id = id;
        this.name = name;
        this.suitablePHMin = suitablePHMin;
        this.suitablePHMax = suitablePHMax;
        this.requiredWater = requiredWater;
        this.season = season;
    }

    
    @PrePersist
    @PreUpdate
    private void validate() {
        if (suitablePHMin > suitablePHMax) {
            throw new RuntimeException("PH min");
        }

        if (!season.equals("Kharif") &&
            !season.equals("Rabi") &&
            !season.equals("Summer")) {
            throw new RuntimeException("Invalid season");
        }
    }

    // ---------- Getters & Setters ----------
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

    // ---------- Builder ----------
    public static class Builder {
        private Long id;
        private String name;
        private Double suitablePHMin;
        private Double suitablePHMax;
        private Double requiredWater;
        private String season;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder suitablePHMin(Double min) {
            this.suitablePHMin = min;
            return this;
        }

        public Builder suitablePHMax(Double max) {
            this.suitablePHMax = max;
            return this;
        }

        public Builder requiredWater(Double water) {
            this.requiredWater = water;
            return this;
        }

        public Builder season(String season) {
            this.season = season;
            return this;
        }

        public Crop build() {
            return new Crop(id, name, suitablePHMin, suitablePHMax, requiredWater, season);
        }
    }
}
