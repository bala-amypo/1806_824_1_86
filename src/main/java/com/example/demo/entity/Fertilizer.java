package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String npkRatio;
    private String recommendedForCrops;

    // ---------- Constructors ----------
    public Fertilizer() {}

    public Fertilizer(Long id, String name, String npkRatio, String recommendedForCrops) {
        this.id = id;
        this.name = name;
        this.npkRatio = npkRatio;
        this.recommendedForCrops = recommendedForCrops;
    }

    // ---------- Validation ----------
    @PrePersist
    @PreUpdate
    private void validate() {
        if (!npkRatio.matches("\\d+-\\d+-\\d+")) {
            throw new RuntimeException("NPK");
        }
    }

    // ---------- Getters & Setters ----------
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNpkRatio() {
        return npkRatio;
    }

    public String getRecommendedForCrops() {
        return recommendedForCrops;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNpkRatio(String npkRatio) {
        this.npkRatio = npkRatio;
    }

    public void setRecommendedForCrops(String recommendedForCrops) {
        this.recommendedForCrops = recommendedForCrops;
    }

    // ---------- Builder ----------
    public static class Builder {
        private Long id;
        private String name;
        private String npkRatio;
        private String recommendedForCrops;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder npkRatio(String npkRatio) {
            this.npkRatio = npkRatio;
            return this;
        }

        public Builder recommendedForCrops(String crops) {
            this.recommendedForCrops = crops;
            return this;
        }

        public Fertilizer build() {
            return new Fertilizer(id, name, npkRatio, recommendedForCrops);
        }
    }
}
