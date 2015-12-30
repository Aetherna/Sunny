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
    private List<CurrentCondition> current_condition;
    private List<Request> request;
    private List<Weather> weather;

    public List<ClimateAverages> getClimateAverages() {
        return climateAverages;
    }

    public void setClimateAverages(List<ClimateAverages> climateAverages) {
        this.climateAverages = climateAverages;
    }

    public List<CurrentCondition> getCurrent_condition() {
        return current_condition;
    }

    public void setCurrent_condition(List<CurrentCondition> current_condition) {
        this.current_condition = current_condition;
    }

    public List<Request> getRequest() {
        return request;
    }

    public void setRequest(List<Request> request) {
        this.request = request;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
