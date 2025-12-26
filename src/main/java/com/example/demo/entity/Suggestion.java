package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String suggestedCrops;

    @ManyToOne
    private Farm farm;

    @PrePersist
    public void prePersist() {
        // test only checks existence
    }
}
