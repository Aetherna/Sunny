package com.aethernadev.sunny.data;

import org.joda.time.DateTime;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class HourlyWeather {
    private DateTime time;
    private double temperature;

    public DateTime getTime() {
        return time;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
