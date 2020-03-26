package com.example.labor.main.interactor;

import android.util.Log;
import android.widget.Toast;

import com.example.labor.main.interactor.event.CreateCivilizationEvent;
import com.example.labor.main.interactor.event.GetCivilizationsEvent;
import com.example.labor.main.interactor.event.RemoveCivilizationEvent;
import com.example.labor.main.model.Civilization;
import com.example.labor.main.model.CivilizationResult;
import com.example.labor.main.service.CivilizationApi;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class Interactor {

    CivilizationApi civilizationApi;

    @Inject
    public Interactor(CivilizationApi civilizationApi) {
        this.civilizationApi = civilizationApi;
        EventBus.getDefault().register(this);
    }

    public void removeCivilization(int index){
        Log.v("Remove", "Remove civilization in position " + index + ".");
        //TODO Ez törli ki majd db-ből a civilization-t
    }

    public void createCivilization(Civilization civilization){
        Log.v("Create", "Create civilization");
        //TODO Itt teszi majd be a db-be a civilization-t
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final CreateCivilizationEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
        } else {
            createCivilization(event.getCivilization());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final RemoveCivilizationEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
        } else {
            removeCivilization(event.getPosition());
        }
    }

    public void getCivilizations() {
        GetCivilizationsEvent event = new GetCivilizationsEvent();

        try{
            Call<CivilizationResult> civilizationsCall = civilizationApi.getCivilizations();
            Response<CivilizationResult> response = civilizationsCall.execute();

            //TODO itt kell majd betenni a db-be a népeket

            if(response.code() != 200){
                throw new Exception("A népek lekérése sikertelen!");
            }

            event.setCode(response.code());
            event.setCivilizations(response.body().getCivilizations());
            EventBus.getDefault().post(event);
        }
        catch(Exception e){
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }
}
