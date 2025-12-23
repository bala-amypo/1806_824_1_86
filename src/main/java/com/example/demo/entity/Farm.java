package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private User owner;

    private String name;

    private Double soilPH;

    private Double waterLevel;

    private String season;

    @PrePersist
    @PreUpdate
    private void validate() {
        if (soilPH < 3 || soilPH > 10) {
            throw new IllegalArgumentException("pH");
        }
        if (!season.matches("Kharif|Rabi|Summer")) {
            throw new IllegalArgumentException("Invalid season");
        }
    }
}
