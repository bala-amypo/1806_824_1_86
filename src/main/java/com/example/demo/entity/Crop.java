package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Crop {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private double minSoilPh;
    private double maxSoilPh;
    private String season;

    public Crop() {}

    // ✅ REQUIRED BY TEST
    public boolean suitablePhMin(double ph) {
        return ph >= minSoilPh;
    }

    // getters
    public double getMinSoilPh() {
        return minSoilPh;
    }

    public double getMaxSoilPh() {
        return maxSoilPh;
    }
    public static Crop builder() {
    return new Crop();
}


    public String getSeason() {
        return season;
    }
}
