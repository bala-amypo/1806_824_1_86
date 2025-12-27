package com.example.demo.service.impl;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.repository.FarmRepository;
import com.example.demo.service.FarmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository repo;

    public FarmServiceImpl(FarmRepository repo) {
        this.repo = repo;
    }

    @Override
    public Farm createFarm(FarmRequest req, Long ownerId) {
        Farm farm = Farm.builder()
                .name(req.getName())
                .location(req.getLocation())
                .size(req.getSize())
                .ownerId(ownerId)
                .build();
        return repo.save(farm);
    }

    @Override
    public List<Farm> getFarmsByOwner(Long ownerId) {
        return repo.findByOwnerId(ownerId);
    }
}
