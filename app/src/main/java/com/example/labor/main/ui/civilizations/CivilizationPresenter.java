package com.example.labor.main.ui.civilizations;

import com.example.labor.main.di.Network;
import com.example.labor.main.interactor.CivilizationInteractor;
import com.example.labor.main.interactor.event.GetCivilizationEvent;
import com.example.labor.main.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class CivilizationPresenter extends Presenter<CivilizationScreen> {
    Executor networkExecutor;
    CivilizationInteractor civilizationInteractor;

    @Inject
    public CivilizationPresenter(@Network Executor networkExecutor, CivilizationInteractor civilizationInteractor) {
        this.networkExecutor = networkExecutor;
        this.civilizationInteractor = civilizationInteractor;
    }

    @Override
    public void attachScreen(CivilizationScreen screen) {
        super.attachScreen(screen);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen();
    }

    public void refreshArtists(final String artistQuery) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                civilizationInteractor.getCivilizations();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetCivilizationEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                screen.showCivilizations(event.getCivilizations());
            }
        }
    }
}
