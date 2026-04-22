package com.example.backend_api_team10.dto;


public class DietCountDTO {
    
    
    private String diet;
    private Long count;

    public DietCountDTO(String diet, Long count) {
        this.diet = diet;
        this.count = count;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getDiet() {
        return diet;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

}
