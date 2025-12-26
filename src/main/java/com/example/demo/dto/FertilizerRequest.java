package com.example.demo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor @NoArgsConstructor @Data
public class FertilizerRequest {
    private String name;
    private String npkRatio;
    private String recommendedFor;
}
