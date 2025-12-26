package com.example.demo.dto;

import lombok.Data;

@Data
public class FarmRequest {
    private String farmerName;
    private String location;
    private Double landArea;
}
