package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.repository.FarmRepository;
import com.example.demo.service.FarmService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;

    public FarmServiceImpl(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @Override
    public Farm createFarm(Farm farm, Long userId) {
        // userId can be mapped to owner later if needed
        return farmRepository.save(farm);
    }

    @Override
    public Farm getFarmById(Long farmId) {
        return farmRepository.findById(farmId).orElse(null);
    }

    @Override
    public void deleteFarm(Long farmId) {
        farmRepository.deleteById(farmId);
    }

    @Override
    public Farm updateFarm(Long farmId, Farm farm) {
        Optional<Farm> existing = farmRepository.findById(farmId);
        if (existing.isPresent()) {
            Farm f = existing.get();
            f.setName(farm.getName());
            f.setSoilPH(farm.getSoilPH());
            f.setWaterLevel(farm.getWaterLevel());
            f.setSeason(farm.getSeason());
            return farmRepository.save(f);
        }
        return null;
    }
}
