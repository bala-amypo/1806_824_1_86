package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Farm {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private double soilPH;
    private double waterLevel;
    private String season;

    @ManyToOne
    private User owner;
}
