package aethernadev.com.weatherprovider.mapper.forecast;

import com.aethernadev.sunny.data.DayWeather;

import javax.inject.Inject;

import aethernadev.com.weatherprovider.mapper.forecast.dayweather.ForecastDateMapper;
import aethernadev.com.weatherprovider.mapper.forecast.dayweather.HourlyWeatherMapper;
import aethernadev.com.weatherprovider.mapper.forecast.dayweather.WeatherMinMaxMapper;
import aethernadev.com.weatherprovider.model.weatherforecast.weather.Weather;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class DayWeatherMapper {

    ForecastDateMapper dateMapper;
    HourlyWeatherMapper hourlyMapper;
    WeatherMinMaxMapper minMaxMapper;

    @Inject
    public DayWeatherMapper(ForecastDateMapper dateMapper, HourlyWeatherMapper hourlyMapper, WeatherMinMaxMapper minMaxMapper) {
        this.dateMapper = dateMapper;
        this.hourlyMapper = hourlyMapper;
        this.minMaxMapper = minMaxMapper;
    }

    DayWeather from(Weather weather) {

        DayWeather result = new DayWeather();

        result.setDate(dateMapper.from(weather.getDate()));
        result.setForecast(hourlyMapper.from(weather.getHourly()));
        result.setWeatherMinMAx(minMaxMapper.from(weather));

        return result;
    }
}
