package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    private User owner;

    private String name;

    private Double soilPH;

    private Double waterLevel;

    private String season;

    @PrePersist
    @PreUpdate
    public void validateFarm() {

        if (soilPH == null || soilPH < 3 || soilPH > 10) {
            throw new IllegalArgumentException("pH");
        }

        if (!season.equalsIgnoreCase("Kharif")
                && !season.equalsIgnoreCase("Rabi")
                && !season.equalsIgnoreCase("Summer")) {
            throw new IllegalArgumentException("Invalid season");
        }
    }
}
