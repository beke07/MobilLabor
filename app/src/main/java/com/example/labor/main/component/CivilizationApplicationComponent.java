package com.example.labor.main.component;

import com.example.labor.main.interactor.CivilizationInteractor;
import com.example.labor.main.network.NetworkModule;
import com.example.labor.main.ui.UIModule;
import com.example.labor.main.ui.civilizations.CivilizationPresenter;
import com.example.labor.main.ui.civilizations.CivilizationsFragment;
import com.example.labor.main.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class})
public interface CivilizationApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(CivilizationInteractor civilizationInteractor);

    void inject(CivilizationsFragment civilizationsFragment);

    void inject(CivilizationPresenter civilizationPresenter);
}
