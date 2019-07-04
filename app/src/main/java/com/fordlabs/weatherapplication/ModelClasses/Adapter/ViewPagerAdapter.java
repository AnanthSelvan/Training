package com.fordlabs.weatherapplication.ModelClasses.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fordlabs.weatherapplication.ModelClasses.UI.CityOne;
import com.fordlabs.weatherapplication.ModelClasses.UI.CityTwo;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public Fragment[] childFragments;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        childFragments = new Fragment[]
                {
                        new CityOne(),
                        new CityTwo()
                };
    }

    @Override
    public Fragment getItem(int i) {
        return childFragments[i];
    }

    @Override
    public int getCount() {
        return childFragments.length;
    }
}
