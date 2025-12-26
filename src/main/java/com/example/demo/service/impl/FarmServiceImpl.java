package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;

@Service
public class FarmServiceImpl implements FarmService {

    @Override
    public Farm createFarm(Farm farm, long userId) {
        return farm;
    }

    @Override
    public Farm getFarmById(long farmId) {
        return null;
    }

    @Override
    public Farm updateFarm(long farmId, Farm farm) {
        return farm;
    }

    @Override
    public void deleteFarm(long farmId) {
        // delete logic
    }
}
