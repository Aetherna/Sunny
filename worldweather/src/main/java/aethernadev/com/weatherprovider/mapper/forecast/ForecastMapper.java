package aethernadev.com.weatherprovider.mapper.forecast;

import android.support.annotation.NonNull;

import com.aethernadev.sunny.data.DayWeather;
import com.aethernadev.sunny.data.Forecast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import aethernadev.com.weatherprovider.model.weatherforecast.WeatherForecast;
import aethernadev.com.weatherprovider.model.weatherforecast.WeatherForecastResponse;
import aethernadev.com.weatherprovider.model.weatherforecast.weather.Weather;

/**
 * Created by Aetherna.
 */
public class ForecastMapper {

    private CurrentConditionsMapper currentConditionsMapper;
    private DayWeatherMapper dayWeatherMapper;

    @Inject
    public ForecastMapper(CurrentConditionsMapper currentConditionsMapper, DayWeatherMapper dayWeatherMapper) {
        this.currentConditionsMapper = currentConditionsMapper;
        this.dayWeatherMapper = dayWeatherMapper;
    }

    public Forecast from(WeatherForecastResponse forecastResponse) {

        WeatherForecast weatherForecast = forecastResponse.getWeatherForecast();
        if (weatherForecast == null) {
            throw new RuntimeException("WeatherForecast can not be null!");
        }

        Forecast forecast = new Forecast();
        forecast.setCurrentConditions(currentConditionsMapper.from(weatherForecast));

        List<DayWeather> dailyForecast = getDailyForecast(weatherForecast);
        forecast.setDailyForecasts(dailyForecast);

        return forecast;
    }

    @NonNull
    private List<DayWeather> getDailyForecast(WeatherForecast weatherForecast) {
        List<Weather> daysForecasts = weatherForecast.getDaysForecasts();

        List<DayWeather> dailyForecast = new ArrayList<>();
        for (Weather weather : daysForecasts) {
            dailyForecast.add(dayWeatherMapper.from(weather));
        }
        return dailyForecast;
    }

}
