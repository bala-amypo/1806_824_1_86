package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.Farm;
import com.example.demo.repository.FarmRepository;
import com.example.demo.service.FarmService;

public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;

    public FarmServiceImpl(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @Override
    public List<Farm> getFarmsByOwner(Long ownerId) {
        return farmRepository.findAll();
    }

    @Override
    public Farm getFarmById(Long farmId) {
        return farmRepository.findById(farmId).orElse(null);
    }
}
