package com.aethernadev.sunny.data;

import java.util.List;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class Forecast {

    private List<DayWeather> daysForecasts;

    public List<DayWeather> getDaysForecasts() {
        return daysForecasts;
    }

    public void setDaysForecasts(List<DayWeather> daysForecasts) {
        this.daysForecasts = daysForecasts;
    }
}
