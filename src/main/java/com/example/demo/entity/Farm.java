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

    private String name;

    // MUST be exactly this
    private double soilPH;

    private double waterLevel;
    private String season;
}
