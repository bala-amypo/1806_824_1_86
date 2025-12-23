package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Each farm belongs to a single user
    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    private User owner;

    private String name;

    private Double soilPH;

    private Double waterLevel;

    private String season;

    // ---------- Constructors ----------
    public Farm() {}

    public Farm(Long id, User owner, String name, Double soilPH, Double waterLevel, String season) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.soilPH = soilPH;
        this.waterLevel = waterLevel;
        this.season = season;
    }

    // ---------- Validation ----------
    @PrePersist
    @PreUpdate
    private void validate() {
        if (soilPH == null || soilPH < 3 || soilPH > 10) {
            throw new IllegalArgumentException("pH");
        }

        if (!season.equals("Kharif") &&
            !season.equals("Rabi") &&
            !season.equals("Summer")) {
            throw new IllegalArgumentException("Invalid season");
        }
    }

    // ---------- Getters & Setters ----------
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

    // ---------- Builder ----------
    public static class Builder {
        private Long id;
        private User owner;
        private String name;
        private Double soilPH;
        private Double waterLevel;
        private String season;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder owner(User owner) {
            this.owner = owner;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder soilPH(Double soilPH) {
            this.soilPH = soilPH;
            return this;
        }

        public Builder waterLevel(Double waterLevel) {
            this.waterLevel = waterLevel;
            return this;
        }

        public Builder season(String season) {
            this.season = season;
            return this;
        }

        public Farm build() {
            return new Farm(id, owner, name, soilPH, waterLevel, season);
        }
    }
}
