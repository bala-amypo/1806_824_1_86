package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cropName;
    private String fertilizerName;

    public Suggestion() {
    }

    public Suggestion(Long id, String cropName, String fertilizerName) {
        this.id = id;
        this.cropName = cropName;
        this.fertilizerName = fertilizerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getFertilizerName() {
        return fertilizerName;
    }

    public void setFertilizerName(String fertilizerName) {
        this.fertilizerName = fertilizerName;
    }
}
