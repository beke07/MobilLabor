package com.example.labor.main.service;

import com.example.labor.main.model.Civilization;
import com.example.labor.main.model.CivilizationResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface  CivilizationApi {

    @GET("civilizations")
    Call<CivilizationResult> getCivilizations();
}
