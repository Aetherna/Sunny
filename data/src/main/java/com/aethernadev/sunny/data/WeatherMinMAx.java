package com.aethernadev.sunny.data;

/**
 * Created by Aetherna.
 */
public class WeatherMinMAx {

    private String description;
    private int temperatureCelsiusMax;
    private int temperatureCelsiusMin;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemperatureCelsiusMax() {
        return temperatureCelsiusMax;
    }

    public void setTemperatureCelsiusMax(int temperatureCelsiusMax) {
        this.temperatureCelsiusMax = temperatureCelsiusMax;
    }

    public int getTemperatureCelsiusMin() {
        return temperatureCelsiusMin;
    }

    public void setTemperatureCelsiusMin(int temperatureCelsiusMin) {
        this.temperatureCelsiusMin = temperatureCelsiusMin;
    }
}
