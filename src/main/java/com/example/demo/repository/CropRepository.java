package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

    @Query("SELECT c FROM Crop c WHERE c.nitrogen <= :nitrogen AND c.phosphorus <= :phosphorus AND c.soilType = :soilType")
List<Crop> findSuitableCrops(@Param("nitrogen") double nitrogen,
                             @Param("phosphorus") double phosphorus,
                             @Param("soilType") String soilType);
}