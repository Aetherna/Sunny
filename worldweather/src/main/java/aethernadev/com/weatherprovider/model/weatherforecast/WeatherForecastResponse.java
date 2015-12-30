package aethernadev.com.weatherprovider.model.weatherforecast;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class WeatherForecastResponse {

    @SerializedName("data")
    private WeatherForecast weatherForecast;

    public WeatherForecast getWeatherForecast() {
        return weatherForecast;
    }

    public void setWeatherForecast(WeatherForecast weatherForecast) {
        this.weatherForecast = weatherForecast;
    }
}
