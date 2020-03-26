package com.example.labor.main.view.create;

import com.example.labor.main.interactor.event.CreateCivilizationEvent;
import com.example.labor.main.interactor.Interactor;
import com.example.labor.main.model.Civilization;
import com.example.labor.main.presenter.Presenter;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

public class CreatePresenter extends Presenter<CreateScreen> {
    Interactor interactor;

    public CreatePresenter() {
    }

    @Inject
    public CreatePresenter(Interactor interactor) {
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

    public void createCivilization(Civilization civilization){

        CreateCivilizationEvent event = new CreateCivilizationEvent();

        try{
            event.setCode(200);
            event.setCivilization(civilization);
            EventBus.getDefault().post(event);
        }
        catch(Exception e){
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }
}
