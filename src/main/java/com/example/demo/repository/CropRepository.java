package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {

    List<Crop> findSuitableCrops(double ph, String season);

    List<Crop> findSuitableCrops(double min, double max, String season);
}
