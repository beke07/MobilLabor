package com.example.labor.main.data;

import androidx.lifecycle.LiveData;

import com.example.labor.main.model.Civilization;

import java.util.List;

public interface ICivilizationRepository {
    void insert(Civilization civilization);

    void update(Civilization civilization);

    void delete(int index);

    void deleteAll();

    Civilization getById(int id);

    LiveData<List<Civilization>> getAll();
}
