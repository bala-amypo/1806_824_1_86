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

    private double soilPH;   // 🔥 MUST MATCH QUERY

    private String season;

    public Crop() {
    }

    public Crop(String name, double soilPH, String season) {
        this.name = name;
        this.soilPH = soilPH;
        this.season = season;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSoilPH() {
        return soilPH;
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

    public void setSoilPH(double soilPH) {
        this.soilPH = soilPH;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
