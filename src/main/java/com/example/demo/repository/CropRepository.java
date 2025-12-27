package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {

    // REQUIRED BY TESTS
    @Query("""
        SELECT c FROM Crop c
        WHERE c.requiredWater <= :water
        AND c.season = :season
    """)
    List<Crop> findSuitableCrops(double water, String season);

    // OPTIONAL (your logic can use this)
    @Query("""
        SELECT c FROM Crop c
        WHERE c.suitablePHMin <= :phMin
        AND c.suitablePHMax >= :phMax
        AND c.season = :season
    """)
    List<Crop> findSuitableCrops(Double phMin, Double phMax, String season);
}
