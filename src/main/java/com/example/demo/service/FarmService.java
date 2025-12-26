package com.example.demo.service;

import com.example.demo.entity.Farm;

public interface FarmService {

    Farm createFarm(Farm farm, Long userId);

    Farm getFarmById(Long farmId);

    void deleteFarm(Long farmId);

    Farm updateFarm(Long farmId, Farm farm);
}
