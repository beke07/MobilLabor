package com.example.labor.main.interactor;

import androidx.lifecycle.LiveData;

import com.example.labor.main.db.CivilizationRepository;
import com.example.labor.main.interactor.event.GetCivilizationsEvent;
import com.example.labor.main.interactor.event.RemoveCivilizationEvent;
import com.example.labor.main.model.Civilization;
import com.example.labor.main.model.CivilizationResult;
import com.example.labor.main.service.CivilizationApi;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class Interactor {

    CivilizationApi civilizationApi;
    CivilizationRepository civilizationRepository;

    @Inject
    public Interactor(CivilizationApi civilizationApi, CivilizationRepository civilizationRepository) {
        this.civilizationApi = civilizationApi;
        this.civilizationRepository = civilizationRepository;
        EventBus.getDefault().register(this);
    }

    public void removeCivilization(int index) {
        civilizationRepository.delete(index);
    }

    public void createCivilization(Civilization civilization) {
        civilizationRepository.insert(civilization);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final RemoveCivilizationEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
        } else {
            removeCivilization(event.getPosition());
        }
    }

    public LiveData<List<Civilization>> getCivilizations(){
        return civilizationRepository.getAll();
    }

    public void initCivilizations() {
        final GetCivilizationsEvent event = new GetCivilizationsEvent();

        try {
            Call<CivilizationResult> civilizationsCall = civilizationApi.getCivilizations();
            Response<CivilizationResult> response = civilizationsCall.execute();

            if (response.code() != 200) {
                throw new Exception("A népek lekérése sikertelen!");
            }

            List<Civilization> civilizationResult = response.body().getCivilizations();

            for (Civilization civilization : civilizationResult) {
                civilizationRepository.insert(civilization);
            }

            event.setCode(response.code());
            event.setCivilizations(civilizationResult);
        } catch (Exception e) {
            event.setThrowable(e);
        }

        EventBus.getDefault().post(event);
    }
}
