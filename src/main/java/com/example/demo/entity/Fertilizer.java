package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String usage;

    public Fertilizer() {
    }

    public Fertilizer(Long id, String name, String usage) {
        this.id = id;
        this.name = name;
        this.usage = usage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }
}
