package com.example.labor.main;

import android.app.Application;

import com.example.labor.main.component.CivilizationApplicationComponent;
import com.example.labor.main.component.DaggerCivilizationApplicationComponent;
import com.example.labor.main.ui.UIModule;

public class CivilizationApplication extends Application {
    public static CivilizationApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerCivilizationApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
