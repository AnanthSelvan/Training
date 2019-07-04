package com.fordlabs.weatherapplication.ModelClasses.RetrofitInstance;

import com.fordlabs.weatherapplication.ModelClasses.NetworkLayer.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RetrofitClientInstance {


    @Headers({
           "X-RapidAPI-Key: 9dcafd6a6dmsh3e60e80f6becb4bp1fd4aejsnd7bfc9ab267f",
    }

    )
    @GET("/weather")
    Call<Example> getCurrentCity(@Query("q") String place);

}
