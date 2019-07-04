package com.fordlabs.weatherapplication.ModelClasses.UI;

import android.app.ProgressDialog;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.fordlabs.weatherapplication.ModelClasses.Adapter.ViewPagerAdapter;
import com.fordlabs.weatherapplication.ModelClasses.NetworkLayer.Example;
import com.fordlabs.weatherapplication.ModelClasses.RetrofitInstance.RetrofitClient;
import com.fordlabs.weatherapplication.ModelClasses.RetrofitInstance.RetrofitClientInstance;
import com.fordlabs.weatherapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }


}
