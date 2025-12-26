package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fertilizers")
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fertilizerName;

    @Column(nullable = false)
    private String cropType;

    private int quantity;

    public Fertilizer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFertilizerName() {
        return fertilizerName;
    }

    public void setFertilizerName(String fertilizerName) {
        this.fertilizerName = fertilizerName;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
