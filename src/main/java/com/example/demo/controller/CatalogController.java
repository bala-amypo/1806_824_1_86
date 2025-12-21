package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    private void checkAdmin(Authentication auth) {
        boolean isAdmin = auth.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("ROLE_ADMIN"));

        if (!isAdmin) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Admin access required");
        }
    }

    @PostMapping("/crop")
    public Crop addCrop(@RequestBody CropRequest request,
                        Authentication authentication) {

        checkAdmin(authentication);

        Crop crop = Crop.builder()
                .name(request.getName())
                .suitablePHMin(request.getSuitablePHMin())
                .suitablePHMax(request.getSuitablePHMax())
                .requiredWater(request.getRequiredWater())
                .season(request.getSeason())
                .build();

        return catalogService.addCrop(crop);
    }

    @PostMapping("/fertilizer")
    public Fertilizer addFertilizer(@RequestBody FertilizerRequest request,
                                    Authentication authentication) {

        checkAdmin(authentication);

        Fertilizer fertilizer = Fertilizer.builder()
                .name(request.getName())
                .npkRatio(request.getNpkRatio())
                .recommendedForCrops(request.getRecommendedForCrops())
                .build();

        return catalogService.addFertilizer(fertilizer);
    }

    @GetMapping("/crops/suitable")
    public List<Crop> findSuitableCrops(@RequestParam Double ph,
                                        @RequestParam Double water,
                                        @RequestParam String season) {
        return catalogService.findSuitableCrops(ph, water, season);
    }

    @GetMapping("/fertilizers/by-crop")
    public List<Fertilizer> findFertilizersByCrop(@RequestParam String name) {
        return catalogService.findFertilizersForCrops(List.of(name));
    }
}
