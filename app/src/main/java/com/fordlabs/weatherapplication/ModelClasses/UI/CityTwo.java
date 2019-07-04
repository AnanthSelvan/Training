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

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CityTwo extends Fragment {

    private TextView city;
    private TextView temperature;
    private TextView description;
    private View view;
    private Context context;
    public Example getData;

    public CityTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_city_two, container, false);
        city = view.findViewById(R.id.city);
        temperature = view.findViewById(R.id.temperature);
        description = view.findViewById(R.id.description);
        context = view.getContext();
        generateData();
        return view;
    }

    public void setData(Example body) {
        city.setText(body.getName());
        temperature.setText(String.valueOf(body.mainValue.getTemp()));
        description.setText((body.weather.get(0).description));

    }


    public void generateData() {

        RetrofitClientInstance service = RetrofitClient.getRetrofitInstance().create(RetrofitClientInstance.class);

        Call<Example> call = service.getCurrentCity("bangalore");

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example>call, Response<Example> response) {
                getData = response.body();
                setData(getData);

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(context,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
