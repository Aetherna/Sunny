package aethernadev.com.weatherprovider.model.weatherforecast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import aethernadev.com.weatherprovider.model.weatherforecast.climateaverages.ClimateAverages;
import aethernadev.com.weatherprovider.model.weatherforecast.currentcondition.CurrentCondition;
import aethernadev.com.weatherprovider.model.weatherforecast.request.Request;
import aethernadev.com.weatherprovider.model.weatherforecast.weather.Weather;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class WeatherForecast {
    @SerializedName("ClimateAverages")
    private List<ClimateAverages> climateAverages;
    @SerializedName("current_condition")
    private List<CurrentCondition> currentConditions;
    private List<Request> request;
    @SerializedName("weather")
    private List<Weather> daysForecasts;

    public List<ClimateAverages> getClimateAverages() {
        return climateAverages;
    }

    public void setClimateAverages(List<ClimateAverages> climateAverages) {
        this.climateAverages = climateAverages;
    }

    public List<CurrentCondition> getCurrentConditions() {
        return currentConditions;
    }

    public void setCurrentConditions(List<CurrentCondition> currentConditions) {
        this.currentConditions = currentConditions;
    }

    public List<Request> getRequest() {
        return request;
    }

    public void setRequest(List<Request> request) {
        this.request = request;
    }

    public List<Weather> getDaysForecasts() {
        return daysForecasts;
    }

    public void setDaysForecasts(List<Weather> daysForecasts) {
        this.daysForecasts = daysForecasts;
    }
}
