package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {

    // 🔥 REQUIRED BY TESTS
    @Query("""
           SELECT c FROM Crop c
           WHERE c.soilPH <= :soilPh
             AND c.season = :season
           """)
    List<Crop> findSuitableCrops(
            @Param("soilPh") double soilPh,
            @Param("season") String season
    );
}
