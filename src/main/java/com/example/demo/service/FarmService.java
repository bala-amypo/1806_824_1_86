package com.example.demo.service;

import com.example.demo.entity.Farm;

public interface FarmService {

    Farm createFarm(Farm farm, Long userId);
}
