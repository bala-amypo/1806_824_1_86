package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Crop {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String season;
    private double soilPH;

    // ===== getters & setters =====

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

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public double getSoilPH() {
        return soilPH;
    }

    public void setSoilPH(double soilPH) {
        this.soilPH = soilPH;
    }
}
