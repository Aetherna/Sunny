package com.aethernadev.sunny.data;

import java.util.List;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class Forecast {

    private List<DayWeather> dailyForecast;
    private CurrentConditions currentConditions;

    public List<DayWeather> getDailyForecast() {
        return dailyForecast;
    }

    public void setDailyForecasts(List<DayWeather> daysForecasts) {
        this.dailyForecast = daysForecasts;
    }

    public CurrentConditions getCurrentConditions() {
        return currentConditions;
    }

    public void setCurrentConditions(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }
}
