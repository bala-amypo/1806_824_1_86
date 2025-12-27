package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.SuggestionService;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private final FarmService fs;
    private final CatalogService cs;
    private final SuggestionRepository repo;

    public SuggestionServiceImpl(FarmService f, CatalogService c, SuggestionRepository r){
        fs=f; cs=c; repo=r;
    }

    public Suggestion generateSuggestion(Long farmId){
        Farm f=fs.getFarmById(farmId);
        List<Crop> crops=cs.findSuitableCrops(f.getSoilPH(),f.getWaterLevel(),f.getSeason());
        List<String> names=crops.stream().map(Crop::getName).toList();
        List<Fertilizer> ferts=cs.findFertilizersForCrops(names);

        Suggestion s=Suggestion.builder()
            .farm(f)
            .suggestedCrops(String.join(",",names))
            .suggestedFertilizers(ferts.stream().map(Fertilizer::getName).collect(Collectors.joining(",")))
            .build();

        return repo.save(s);
    }
}
