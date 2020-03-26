package com.example.labor.main.network;

import android.app.Application;

import com.example.labor.main.service.CivilizationApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Provides
    @Singleton
    public static Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());
    }

    @Provides
    @Singleton
    public static CivilizationApi provideCivilizationApi(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(NetworkConfig.BASE_URL).build().create(CivilizationApi.class);
    }
}
