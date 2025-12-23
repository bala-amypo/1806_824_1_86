package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fertilizer")
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "npk_ratio")
    private String npkRatio;

    @Column(name = "recommended_for_crops")
    private String recommendedForCrops;

    // ---------- Constructors ----------
    public Fertilizer() {
    }

    public Fertilizer(String name, String npkRatio, String recommendedForCrops) {
        this.name = name;
        this.npkRatio = npkRatio;
        this.recommendedForCrops = recommendedForCrops;
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

    public String getNpkRatio() {
        return npkRatio;
    }

    public void setNpkRatio(String npkRatio) {
        this.npkRatio = npkRatio;
    }

    public String getRecommendedForCrops() {
        return recommendedForCrops;
    }

    public void setRecommendedForCrops(String recommendedForCrops) {
        this.recommendedForCrops = recommendedForCrops;
    }
}
