package com.example.labor.main.view.module;

import com.example.labor.main.view.create.CreateActivity;
import com.example.labor.main.view.list.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract CreateActivity contributeCreateActivity();
}