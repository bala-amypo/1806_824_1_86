package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Farm farm;

    private String suggestedCrops;
    private String suggestedFertilizers;

    private LocalDateTime createdAt;

    
    public Suggestion() {}

    public Suggestion(Long id, Farm farm, String suggestedCrops,
                      String suggestedFertilizers, LocalDateTime createdAt) {
        this.id = id;
        this.farm = farm;
        this.suggestedCrops = suggestedCrops;
        this.suggestedFertilizers = suggestedFertilizers;
        this.createdAt = createdAt;
    }

    @PrePersist
    private void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    
    public Long getId() {
        return id;
    }

    public Farm getFarm() {
        return farm;
    }

    public String getSuggestedCrops() {
        return suggestedCrops;
    }

    public String getSuggestedFertilizers() {
        return suggestedFertilizers;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public void setSuggestedCrops(String suggestedCrops) {
        this.suggestedCrops = suggestedCrops;
    }

    public void setSuggestedFertilizers(String suggestedFertilizers) {
        this.suggestedFertilizers = suggestedFertilizers;
    }

   
    public static class Builder {
        private Long id;
        private Farm farm;
        private String suggestedCrops;
        private String suggestedFertilizers;
        private LocalDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder farm(Farm farm) {
            this.farm = farm;
            return this;
        }

        public Builder suggestedCrops(String crops) {
            this.suggestedCrops = crops;
            return this;
        }

        public Builder suggestedFertilizers(String fertilizers) {
            this.suggestedFertilizers = fertilizers;
            return this;
        }

        public Suggestion build() {
            return new Suggestion(id, farm, suggestedCrops, suggestedFertilizers, createdAt);
        }
    }
}
