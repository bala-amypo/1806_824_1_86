package com.example.demo.service;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;

import java.util.List;

public interface FarmService {
    Farm createFarm(Farm farm);
    Farm getFarmById(long id);
    List<Farm> getAllFarms();
}
