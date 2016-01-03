package com.aethernadev.sunny.data;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class CurrentConditions {

    private int temperatureNowCelsius;
    private double pressure;
    private String weatherDescription;

    public int getTemperatureNowCelsius() {
        return temperatureNowCelsius;
    }

    public void setTemperatureNowCelsius(int temperatureNowCelsius) {
        this.temperatureNowCelsius = temperatureNowCelsius;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }
}
