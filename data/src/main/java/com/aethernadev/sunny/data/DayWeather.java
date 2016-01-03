package com.aethernadev.sunny.data;


import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class DayWeather {

    private DateTime date;
    private List<HourlyWeather> forecast;
    private WeatherMinMAx weatherMinMAx;

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public List<HourlyWeather> getForecast() {
        return forecast;
    }

    public void setForecast(List<HourlyWeather> forecast) {
        this.forecast = forecast;
    }

    public WeatherMinMAx getWeatherMinMAx() {
        return weatherMinMAx;
    }

    public void setWeatherMinMAx(WeatherMinMAx weatherMinMAx) {
        this.weatherMinMAx = weatherMinMAx;
    }
}
