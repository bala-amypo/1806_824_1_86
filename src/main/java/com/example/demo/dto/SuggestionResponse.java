package com.example.demo.dto;

public class SuggestionResponse {

    private Long id;
    private String cropName;
    private String fertilizerName;
    private String npkRatio;

    public SuggestionResponse() {}

    public SuggestionResponse(Long id, String cropName,
                              String fertilizerName, String npkRatio) {
        this.id = id;
        this.cropName = cropName;
        this.fertilizerName = fertilizerName;
        this.npkRatio = npkRatio;
    }

    public Long getId() { return id; }
    public String getCropName() { return cropName; }
    public String getFertilizerName() { return fertilizerName; }
    public String getNpkRatio() { return npkRatio; }
}
