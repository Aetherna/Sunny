package com.aethernadev.sunny.main.dailyforecast;

import android.content.Context;

import com.aethernadev.sunny.R;

import javax.inject.Inject;

/**
 * Created by Aetherna.
 */
public class WeekDay {

    private Context context;
    private String[] names;

    @Inject
    public WeekDay(Context context) {
        names = context.getResources().getStringArray(R.array.week_days);
    }

    /**
     * Joda time counts days from 1
     * @return Week name fetched from resources
     */
    public String getName(int jodaTimeDay) {
        return names[jodaTimeDay - 1];
    }
}
