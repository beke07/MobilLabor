package com.example.labor.main.view.create;

import com.example.labor.main.di.Network;
import com.example.labor.main.interactor.Interactor;
import com.example.labor.main.model.Civilization;
import com.example.labor.main.presenter.Presenter;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class CreatePresenter extends Presenter<CreateScreen> {
    private Executor networkExecutor;
    Interactor interactor;

    public CreatePresenter() {
    }

    @Inject
    public CreatePresenter(@Network Executor networkExecutor, Interactor interactor) {
        this.networkExecutor = networkExecutor;
        this.interactor = interactor;
    }

    @Override
    public void attachScreen(CreateScreen screen) {
        super.attachScreen(screen);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen();
    }

    public void createCivilization(final Civilization civilization){
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                interactor.createCivilization(civilization);
            }
        });
    }
}
