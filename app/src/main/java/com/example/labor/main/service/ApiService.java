package com.example.labor.main.service;

import com.example.labor.main.model.CivilizationResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("civilizations")
    Call<CivilizationResult> getCivilizations();
}
