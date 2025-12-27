package com.example.demo.service.impl;

import com.example.demo.repository.FarmRepository;
import com.example.demo.service.FarmService;

public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;

    public FarmServiceImpl(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    // implement ALL interface methods
}
