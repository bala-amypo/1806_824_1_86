package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // TEST EXPECTS THESE EXACT FIELD NAMES
    private double suitablePHMin;
    private double suitablePHMax;

    private String season;
}
