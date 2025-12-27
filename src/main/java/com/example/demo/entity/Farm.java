package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Farm {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User owner;

    private String name;
    private Double soilPH;
    private Double waterLevel;
    private String season;

    @PrePersist
    public void validate() {
        if (soilPH < 3 || soilPH > 10)
            throw new IllegalArgumentException("pH");
        if (!com.example.demo.util.ValidationUtil.validSeason(season))
            throw new IllegalArgumentException("Invalid season");
    }
}
