package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "crops")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "ph_min")
    private Double suitablePHMin;

    @Column(name = "ph_max")
    private Double suitablePHMax;

    @Column(name = "required_water")
    private Double requiredWater;

    @Column(nullable = false)
    private String season;

    public Crop() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSuitablePHMin() {
        return suitablePHMin;
    }

    public Double getSuitablePHMax() {
        return suitablePHMax;
    }

    public Double getRequiredWater() {
        return requiredWater;
    }

    public String getSeason() {
        return season;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuitablePHMin(Double suitablePHMin) {
        this.suitablePHMin = suitablePHMin;
    }

    public void setSuitablePHMax(Double suitablePHMax) {
        this.suitablePHMax = suitablePHMax;
    }

    public void setRequiredWater(Double requiredWater) {
        this.requiredWater = requiredWater;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
