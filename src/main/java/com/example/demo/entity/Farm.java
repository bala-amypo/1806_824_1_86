package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
public class Farm {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private double soilPH;
    private String waterLevel;
    private String season;

    @ManyToOne
    private User owner;

    public static Farm builder() {
        return new Farm();
    }

    // getters & setters
    public double getSoilPH() {
        return soilPH;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
