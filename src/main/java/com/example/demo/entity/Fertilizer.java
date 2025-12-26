package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fertilizer {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String npkRatio;
    private String recommendedForCrops;
}
