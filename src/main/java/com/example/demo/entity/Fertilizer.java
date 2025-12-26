package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fertilizer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String npkRatio;

    // Stores recommended crops as a comma-separated string, e.g., "Wheat,Rice,Corn"
    private String recommendedForCrops;
}
