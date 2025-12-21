package com.example.demo.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;

@Service
public class FarmService {

    public Farm createFarm(FarmRequest req, Authentication auth) {
        return new Farm();
    }

    public List<Farm> listFarms(Authentication auth) {
        return List.of();
    }

    public Farm getFarm(Long farmId) {
        return new Farm();
    }
}
