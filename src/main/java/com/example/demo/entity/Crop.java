package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String season;

    public Crop() {}

    public Crop(String name, String season) {
        this.name = name;
        this.season = season;
    }

    // ✅ REQUIRED by tests
    public static Crop builder() {
        return new Crop();
    }

    public Crop name(String name) {
        this.name = name;
        return this;
    }

    public Crop season(String season) {
        this.season = season;
        return this;
    }

    public Crop build() {
        return this;
    }

    // getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSeason() { return season; }
}
