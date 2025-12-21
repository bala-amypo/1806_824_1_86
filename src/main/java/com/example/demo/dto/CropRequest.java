package com.example.demo.dto;

public class CropRequest {

    private String name;
    private double minPh;
    private double maxPh;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinPh() {
        return minPh;
    }

    public void setMinPh(double minPh) {
        this.minPh = minPh;
    }

    public double getMaxPh() {
        return maxPh;
    }

    public void setMaxPh(double maxPh) {
        this.maxPh = maxPh;
    }
}
