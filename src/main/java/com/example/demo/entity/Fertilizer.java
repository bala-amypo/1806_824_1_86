package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String recommendedForCrops;

    public Fertilizer() {}

    // ✅ REQUIRED by tests
    public static Fertilizer builder() {
        return new Fertilizer();
    }

    public Fertilizer name(String name) {
        this.name = name;
        return this;
    }

    public Fertilizer recommendedForCrops(String crops) {
        this.recommendedForCrops = crops;
        return this;
    }

    public Fertilizer build() {
        return this;
    }

    // getters
    public Long getId() { return id; }
    public String getName() { return name; }

    // ✅ REQUIRED
    public String getRecommendedForCrops() {
        return recommendedForCrops;
    }
}
