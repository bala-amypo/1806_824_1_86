package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
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
    private void validate() {
        if (suitablePHMin > suitablePHMax) {
            throw new RuntimeException("PH min");
        }
        if (!season.matches("Kharif|Rabi|Summer")) {
            throw new RuntimeException("Invalid season");
        }
    }
}
