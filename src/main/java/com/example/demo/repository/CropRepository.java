package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

    @Query("SELECT c FROM Crop c WHERE c.nitrogen <= :nitrogen AND c.soilType = :soilType")
    List<Crop> findSuitableCrops(@Param("nitrogen") double nitrogen,
                                 @Param("soilType") String soilType);
}
