package com.aethernadev.sunny.data;

import org.joda.time.DateTime;

/**
 * Created by Aetherna.
 */
public class HourlyWeather {
    private DateTime time;
    private int temperature;

    public DateTime getTime() {
        return time;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
