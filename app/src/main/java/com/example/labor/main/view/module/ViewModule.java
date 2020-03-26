package com.example.labor.main.view.module;

import android.app.Application;
import android.content.Context;

import com.example.labor.main.CivilizationApplication;
import com.example.labor.main.di.Network;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public class ViewModule {
    private static Context context;

    public ViewModule(Context context) {
        this.context = context;
    }

    @Provides
    public static Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    @Network
    public static Executor provideNetworkExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}
