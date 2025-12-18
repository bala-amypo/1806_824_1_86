package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.web.server.BadRequestException;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double suitablePHMin;

    private Double suitablePHMax;

    private Double requiredWater;

    private String season;

    @PrePersist
    @PreUpdate
    public void validateCrop() {

        if (suitablePHMin > suitablePHMax) {
            throw new BadRequestException("PH min");
        }

        if (!season.equalsIgnoreCase("Kharif")
                && !season.equalsIgnoreCase("Rabi")
                && !season.equalsIgnoreCase("Summer")) {
            throw new BadRequestException("Invalid season");
        }
    }
}
