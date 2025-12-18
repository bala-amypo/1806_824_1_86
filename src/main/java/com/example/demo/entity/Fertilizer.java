package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String npkRatio;

    @Column(length = 500)
    private String recommendedForCrops;

    public Fertilizer() {
    }

    @PrePersist
    @PreUpdate
    public void validateNpk() {

        if (!npkRatio.matches("\\d+-\\d+-\\d+")) {
            throw new IllegalArgumentException("NPK");
        }
    }

    // getters & setters
}
