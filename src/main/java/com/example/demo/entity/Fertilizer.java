package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String npkRatio;
    private String recommendedForCrops;

    @PrePersist
    @PreUpdate
    private void validate() {
        if (!npkRatio.matches("\\d+-\\d+-\\d+")) {
            throw new RuntimeException("NPK");
        }
    }
}
