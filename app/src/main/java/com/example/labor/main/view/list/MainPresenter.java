package com.example.labor.main.view.list;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.labor.main.di.Network;
import com.example.labor.main.interactor.event.GetCivilizationsEvent;
import com.example.labor.main.interactor.Interactor;
import com.example.labor.main.interactor.event.RemoveCivilizationEvent;
import com.example.labor.main.model.Civilization;
import com.example.labor.main.presenter.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {
    Executor networkExecutor;
    Interactor interactor;

    @Inject
    public MainPresenter(@Network Executor networkExecutor, Interactor interactor) {
        this.networkExecutor = networkExecutor;
        this.interactor = interactor;
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen();
    }

    public void refreshCivilizations() {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                interactor.getCivilizations();
            }
        });
    }

    public void initCivilizations() {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                interactor.initCivilizations();
            }
        });
    }

    public void removeCivilization(int position) {

        RemoveCivilizationEvent event = new RemoveCivilizationEvent();

        try {
            event.setCode(200);
            event.setPosition(position);
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

    public void showCivilizations(List<Civilization> civilizations){
        if (screen != null) {
            screen.showCivilizations(civilizations);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetCivilizationsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            showCivilizations(event.getCivilizations());
        }
    }
}
