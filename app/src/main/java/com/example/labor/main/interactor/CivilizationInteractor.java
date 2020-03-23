package com.example.labor.main.interactor;

import com.example.labor.main.interactor.event.GetCivilizationEvent;
import com.example.labor.main.model.CivilizationResult;
import com.example.labor.main.service.ApiService;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class CivilizationInteractor {
    ApiService apiService;

    @Inject
    public CivilizationInteractor(ApiService apiService) {
        this.apiService = apiService;
    }

    public void getCivilizations() {

        GetCivilizationEvent event = new GetCivilizationEvent();
        try {
            Call<CivilizationResult> artistsQueryCall = apiService.getCivilizations();

            Response<CivilizationResult> response = artistsQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setCivilizations(response.body().getCivilizations());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }
}
