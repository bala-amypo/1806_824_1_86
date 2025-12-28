package com.example.demo.repository;

import com.example.demo.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

    // ✅ REQUIRED by tests
    default List<Fertilizer> findByCrop(String cropName) {
        return findAll().stream()
                .filter(f -> f.getRecommendedForCrops() != null &&
                             f.getRecommendedForCrops().contains(cropName))
                .toList();
    }
}
