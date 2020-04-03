package com.example.labor.main.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.labor.main.model.Civilization;

import java.util.List;

@Dao
public interface CivilizationDao {

    @Insert
    void insert(Civilization civilization);

    @Update
    void update(Civilization civilization);

    @Delete
    void delete(Civilization civilization);

    @Query("DELETE FROM civilizations")
    void deleteAll();

    @Query("SELECT * FROM civilizations ORDER BY name ASC")
    LiveData<List<Civilization>> getAll();
}
