package com.example.demo.dto;

public class SuggestionResponse {

    private String cropName;
    private String fertilizerName;
    private String npkRatio;

    public SuggestionResponse() {
    }

    public SuggestionResponse(String cropName, String fertilizerName, String npkRatio) {
        this.cropName = cropName;
        this.fertilizerName = fertilizerName;
        this.npkRatio = npkRatio;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getFertilizerName() {
        return fertilizerName;
    }

    public void setFertilizerName(String fertilizerName) {
        this.fertilizerName = fertilizerName;
    }

    public String getNpkRatio() {
        return npkRatio;
    }

    public void setNpkRatio(String npkRatio) {
        this.npkRatio = npkRatio;
    }
}
