package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // 🔴 THIS FIELD MUST EXIST
    private String crop;

    private String npkRatio;

    public Fertilizer() {}

    public Fertilizer(String name, String crop, String npkRatio) {
        this.name = name;
        this.crop = crop;
        this.npkRatio = npkRatio;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCrop() {
        return crop;
    }

    public String getNpkRatio() {
        return npkRatio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public void setNpkRatio(String npkRatio) {
        this.npkRatio = npkRatio;
    }
}
