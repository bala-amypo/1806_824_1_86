package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import com.example.demo.exception.BadRequestException;

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
    private String recommendedForCrops;

    @PrePersist
    @PreUpdate
    public void validate() {
        if (!npkRatio.matches("\\d+-\\d+-\\d+"))
            throw new BadRequestException("NPK");
    }
}
