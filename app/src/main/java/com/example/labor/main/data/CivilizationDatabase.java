package com.example.labor.main.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.labor.main.model.Civilization;
import com.example.labor.main.model.Converters;

@Database(entities = Civilization.class, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class CivilizationDatabase extends RoomDatabase {

    private static CivilizationDatabase instance;

    public abstract CivilizationDao civilizationDao();

    public static synchronized CivilizationDatabase getInstance(Context context){
        if(instance == null){
            instance = Room
                    .databaseBuilder(context.getApplicationContext(), CivilizationDatabase.class, "civilization_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}
