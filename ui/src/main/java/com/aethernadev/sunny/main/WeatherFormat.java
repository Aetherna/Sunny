package com.aethernadev.sunny.main;

import android.content.Context;

import com.aethernadev.sunny.R;

import javax.inject.Inject;

/**
 * Created by Aetherna on 2015-12-31.
 */
public class WeatherFormat {

    private String celsius;
    private String pascal;

    @Inject
    public WeatherFormat(Context context) {
        this.celsius = context.getResources().getString(R.string.celsius);
        this.pascal = context.getResources().getString(R.string.pascal);
    }

    public String formatToCelsius(int temperature) {
        return temperature + celsius;
    }

    public String formatToPascal(double pressure) {
        return pressure + pascal;
    }
}
