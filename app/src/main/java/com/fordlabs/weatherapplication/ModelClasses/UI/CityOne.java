package com.fordlabs.weatherapplication.ModelClasses.UI;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.fordlabs.weatherapplication.ModelClasses.NetworkLayer.Example;
import com.fordlabs.weatherapplication.ModelClasses.RetrofitInstance.RetrofitClient;
import com.fordlabs.weatherapplication.ModelClasses.RetrofitInstance.RetrofitClientInstance;
import com.fordlabs.weatherapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CityOne extends Fragment {

    private TextView cityName;
    private TextView temperature;
    private TextView description;
    private View view;
    private Context context;
    public Example getData;

    public CityOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_city_one, container, false);
        context = view.getContext();
        cityName = view.findViewById(R.id.cityName);
        temperature = view.findViewById(R.id.temperature);
        description = view.findViewById(R.id.description);
        generateData();
        return view;
    }

    public void setViewData(Example data) {

        cityName.setText(data.getName());
        temperature.setText(String.valueOf(data.mainValue.getTemp()));
        description.setText(data.weather.get(0).description);
    }

    public void generateData() {

        RetrofitClientInstance service = RetrofitClient.getRetrofitInstance().create(RetrofitClientInstance.class);

        Call<Example> call = service.getCurrentCity("chennai");

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example>call, Response<Example> response) {
                getData = response.body();
                setViewData(getData);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(context,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
