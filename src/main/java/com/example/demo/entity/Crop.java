package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.util.ValidationUtil;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Crop {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Double suitablePHMin;
    private Double suitablePHMax;
    private Double requiredWater;
    private String season;

    @PrePersist
    @PreUpdate
    public void validate() {
        if (suitablePHMin > suitablePHMax)
            throw new BadRequestException("PH min");
        if (!ValidationUtil.validSeason(season))
            throw new BadRequestException("Invalid season");
    }
}
