package com.example.labor.main.view.list;

import com.example.labor.main.model.Civilization;

import java.util.List;

public interface MainScreen {
    
    void showCivilizations(List<Civilization> civilizations);

    void showNetworkError(String errorMsg);
}
