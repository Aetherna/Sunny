package aethernadev.com.weatherprovider.mapper.forecast.dayweather;

import com.aethernadev.sunny.data.WeatherMinMAx;

import javax.inject.Inject;

import aethernadev.com.weatherprovider.model.weatherforecast.weather.Weather;

/**
 * Created by Aetherna.
 */
public class WeatherMinMaxMapper {

    @Inject
    public WeatherMinMaxMapper() {
    }

    public WeatherMinMAx from(Weather weather) {
        WeatherMinMAx result = new WeatherMinMAx();

        result.setTemperatureCelsiusMax(weather.getMaxtempC());
        result.setTemperatureCelsiusMin(weather.getMintempC());

        return result;
    }
}
