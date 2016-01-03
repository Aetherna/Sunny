package com.aethernadev.sunny.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aethernadev.sunny.R;
import com.aethernadev.sunny.data.Location;

import java.util.List;

/**
 * Created by Marta on 30/12/2015.
 */
public class WeatherPagerAdapter extends FragmentPagerAdapter {

    private final List<Location> locations;

    public WeatherPagerAdapter(FragmentManager fm, List<Location> locations) {
        super(fm);
        this.locations = locations;
    }

    @Override
    public Fragment getItem(int position) {
        return ForecastFragment.newInstance(locations.get(position));
    }

    @Override
    public int getCount() {
        return locations.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return locations.get(position).getName();
    }


}
