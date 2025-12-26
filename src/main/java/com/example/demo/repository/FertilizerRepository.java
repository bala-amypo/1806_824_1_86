package com.example.demo.repository;

import com.example.demo.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

    // Exact match search
    List<Fertilizer> findByRecommendedForCrops(String recommendedForCrops);

    // Partial match search using LIKE
    @Query("SELECT f FROM Fertilizer f WHERE f.recommendedForCrops LIKE %:cropName%")
    List<Fertilizer> findByCropNameContaining(@Param("cropName") String cropName);
}
