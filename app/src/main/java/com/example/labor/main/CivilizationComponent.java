package com.example.labor.main;

import com.example.labor.main.network.NetworkModule;
import com.example.labor.main.view.module.ActivityModule;
import com.example.labor.main.view.module.ViewModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ActivityModule.class, ViewModule.class, NetworkModule.class, AndroidSupportInjectionModule.class})
public interface CivilizationComponent {

    CivilizationComponent getComponent();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application (CivilizationApplication application);

        CivilizationComponent build();
    }

    void inject(CivilizationApplication application);
}
