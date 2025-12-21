package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    private User owner;

    private String name;

    private Double soilPH;

    private Double waterLevel;

    private String season;

    public Farm() {
    }

    public Farm(Long id, User owner, String name, Double soilPH, Double waterLevel, String season) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.soilPH = soilPH;
        this.waterLevel = waterLevel;
        this.season = season;
    }

    @PrePersist
    @PreUpdate
    public void validateFarm() {

        if (soilPH == null || soilPH < 3 || soilPH > 10) {
            throw new IllegalArgumentException("pH");
        }

        if (!season.equalsIgnoreCase("Kharif")
                && !season.equalsIgnoreCase("Rabi")
                && !season.equalsIgnoreCase("Summer")) {
            throw new IllegalArgumentException("Invalid season");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
