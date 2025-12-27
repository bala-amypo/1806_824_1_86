package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {

    // 🔥 TEST EXPECTS THIS SIGNATURE
    @Query("""
        SELECT c FROM Crop c
        WHERE c.requiredWater <= :water
        AND c.season = :season
    """)
    List<Crop> findSuitableCrops(double water, String season);
}
