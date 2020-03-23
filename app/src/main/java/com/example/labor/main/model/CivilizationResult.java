package com.example.labor.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CivilizationResult {

    @SerializedName("civilizations")
    @Expose
    private List<Civilization> civilizations;

    public List<Civilization> getCivilizations() {
        return civilizations;
    }

    public void setCivilizations(List<Civilization> civilizations) {
        this.civilizations = civilizations;
    }
}
