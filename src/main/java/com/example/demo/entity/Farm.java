package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Farm {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private double soilPH;
    private String season;

    @ManyToOne
    private User owner;

    public void setName(String name) {
        this.name = name;
    }

    public void setSoilPH(double soilPH) {
        this.soilPH = soilPH;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
