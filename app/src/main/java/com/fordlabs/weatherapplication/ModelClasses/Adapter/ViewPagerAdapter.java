package com.fordlabs.weatherapplication.ModelClasses.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fordlabs.weatherapplication.ModelClasses.NetworkLayer.Example;
import com.fordlabs.weatherapplication.R;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    public TextView textView;
    public TextView textView1;
    public TextView textView2;
    Context context;
    private List<String> cityList;
    private List<Example> cityData;

    public ViewPagerAdapter(Context context, List<Example> cityData) {
        this.context = context;
        this.cityData = cityData;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {

        return cityData.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ViewGroup view = (ViewGroup) layoutInflater.inflate(R.layout.weather_page, container, false);

        textView = view.findViewById(R.id.temperature);
        textView1 = view.findViewById(R.id.city);
        textView2 = view.findViewById(R.id.description);

        String city = cityData.get(position).getName();
        Double temperature = cityData.get(position).getMainValue().getTemp();
        String description = cityData.get(position).getWeather().get(0).description;

        textView.setText(temperature.toString());
        textView1.setText(String.valueOf(city));
        textView2.setText(String.valueOf(description));


        container.addView(view);

        return view;
    }
}
