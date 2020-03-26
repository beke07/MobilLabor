package com.example.labor.main.model;

import java.util.List;

public class CivilizationResult {

    private List<Civilization> civilizations;

    public CivilizationResult(List<Civilization> civilizations) {
        this.civilizations = civilizations;
    }

    public List<Civilization> getCivilizations() {
        return civilizations;
    }

    public void setCivilizations(List<Civilization> civilizations) {
        this.civilizations = civilizations;
    }
}
