package com.example.labor.main.ui.civilizations;

import com.example.labor.main.model.Civilization;

import java.util.List;

public interface CivilizationScreen {
    void showCivilizations(List<Civilization> civilizations);

    void showNetworkError(String errorMsg);
}
