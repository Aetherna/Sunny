package com.aethernadev.sunny.data;


import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class DayWeather {

    private DateTime date;
    private List<HourlyWeather> forecast;
    private WeatherDetails weatherDetails;
    private CurrentDetails currentDetails;

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

    public WeatherDetails getWeatherDetails() {
        return weatherDetails;
    }

    public void setWeatherDetails(WeatherDetails weatherDetails) {
        this.weatherDetails = weatherDetails;
    }
}
