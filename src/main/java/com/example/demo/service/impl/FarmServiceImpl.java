package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.repository.FarmRepository;
import com.example.demo.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {

    private final FarmRepository repo;

    @Override
    public Farm createFarm(Farm farm) {
        return repo.save(farm);
    }

    @Override
    public Farm getFarmById(long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public List<Farm> getAllFarms() {
        return repo.findAll();
    }
}
