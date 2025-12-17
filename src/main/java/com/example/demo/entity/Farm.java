package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
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

    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public Double getSoilPH() {
        return soilPH;
    }

    public Double getWaterLevel() {
        return waterLevel;
    }

    public String getSeason() {
        return season;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSoilPH(Double soilPH) {
        this.soilPH = soilPH;
    }

    public void setWaterLevel(Double waterLevel) {
        this.waterLevel = waterLevel;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
