package com.example.demo.service;

import com.example.demo.entity.Farm;
import com.example.demo.entity.User;
import com.example.demo.repository.FarmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmService {

    private final FarmRepository farmRepository;

    public FarmService(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    public Farm createFarm(User owner, String name,
                           Double soilPH, Double waterLevel,
                           String season) {
        Farm farm = new Farm();
        farm.setOwner(owner);
        farm.setName(name);
        farm.setSoilPH(soilPH);
        farm.setWaterLevel(waterLevel);
        farm.setSeason(season);
        return farmRepository.save(farm);
    }

    public List<Farm> getFarmsByOwner(User owner) {
        return farmRepository.findByOwner(owner);
    }

    public Farm getFarmById(Long id) {
        return farmRepository.findById(id).orElse(null);
    }
}
