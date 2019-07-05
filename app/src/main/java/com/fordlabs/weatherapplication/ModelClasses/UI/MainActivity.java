package com.fordlabs.weatherapplication.ModelClasses.UI;

import android.app.ProgressDialog;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.fordlabs.weatherapplication.ModelClasses.Adapter.ViewPagerAdapter;
import com.fordlabs.weatherapplication.ModelClasses.NetworkLayer.Example;
import com.fordlabs.weatherapplication.ModelClasses.RetrofitInstance.RetrofitClient;
import com.fordlabs.weatherapplication.ModelClasses.RetrofitInstance.RetrofitClientInstance;
import com.fordlabs.weatherapplication.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public ViewPager viewPager;
    private static final String TAG = "MainActivity";
    ViewPagerAdapter viewPagerAdapter;

    private List<String> cityList = new ArrayList<>();
    private List<Example> cityData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cityList.add("chennai");
        cityList.add("Mumbai");
        cityList.add("London");
        cityList.add("New york");

        generateData();

        viewPager = findViewById(R.id.viewPager);
    }

    public void generateData() {

        for (String city : cityList) {

            RetrofitClientInstance service = RetrofitClient.getRetrofitInstance().create(RetrofitClientInstance.class);

            Call<Example> call = service.getCurrentCity(city);

            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    if (response.body() != null) {
                        Example currentWeather = response.body();
                        cityData.add(currentWeather);

                        if(cityList.size() == cityData.size())
                        {
                            viewPager.setAdapter(new ViewPagerAdapter(MainActivity.this, cityData));
                        }
                    }
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {

                    Log.d(TAG, "onFailure: "+t.getLocalizedMessage());

                    Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
