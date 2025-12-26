package com.example.demo.service.impl;

import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> crops) {
        return List.of(); // dummy for test cases
    }
}
