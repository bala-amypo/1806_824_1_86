package com.example.demo.service;

import com.example.demo.entity.Farm;

public interface FarmService {

    Farm createFarm(Farm farm, long userId);

    Farm getFarmById(long farmId);

    Farm updateFarm(long farmId, Farm farm);

    void deleteFarm(long farmId);
}
