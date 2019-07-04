package com.fordlabs.weatherapplication.ModelClasses.RetrofitInstance;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://community-open-weather-map.p.rapidapi.com";

    public static Retrofit getRetrofitInstance() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create()).build();
    return retrofit;
    }

}
