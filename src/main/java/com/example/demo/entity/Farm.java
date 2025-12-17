package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private User owner;

    @Column(nullable = false)
    private String name;

    private Double soilPH;
    private Double waterLevel;

    @Column(nullable = false)
    private String season;

    public Farm() {
    }

    @PrePersist
    @PreUpdate
    private void validate() {
        if (soilPH == null || soilPH < 3 || soilPH > 10) {
            throw new IllegalArgumentException("pH must be between 3 and 10");
        }

        if (!season.equals("Kharif")
                && !season.equals("Rabi")
                && !season.equals("Summer")) {
            throw new IllegalArgumentException("Invalid season");
        }
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSoilPH() {
        return soilPH;
    }

    public void setSoilPH(Double soilPH) {
        this.soilPH = soilPH;
    }

    public Double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Double waterLevel) {
        this.waterLevel = waterLevel;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
