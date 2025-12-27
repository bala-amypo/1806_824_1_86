package com.example.demo.service.impl;

import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.SuggestionService;

public class SuggestionServiceImpl implements SuggestionService {

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    public SuggestionServiceImpl(
            CropRepository cropRepository,
            FertilizerRepository fertilizerRepository
    ) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

}
