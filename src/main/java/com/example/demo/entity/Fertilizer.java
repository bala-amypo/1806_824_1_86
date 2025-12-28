package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Fertilizer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String recommendedForCrops;

    public static Fertilizer builder() {
        return new Fertilizer();
    }
}
