package com.example.demo.service;

import com.example.demo.entity.Fertilizer;
import java.util.List;

public interface CatalogService {
    List<Fertilizer> findFertilizersForCrops(List<String> crops);
}
