package aethernadev.com.weatherprovider.mapper.forecast.dayweather;

import com.aethernadev.sunny.data.HourlyWeather;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import aethernadev.com.weatherprovider.model.weatherforecast.weather.Hourly;

/**
 * Created by Aetherna.
 */
public class HourlyWeatherMapper {

    private static final int RESULTS_FOR_3H_TIME_INTERVAL = 8;
    private static final String TIME_ONLY_PATTERN = "HH:mm";

    @Inject
    public HourlyWeatherMapper() {
    }

    public List<HourlyWeather> from(List<Hourly> hourlyForecasts) {

        if (hourlyForecasts.size() != RESULTS_FOR_3H_TIME_INTERVAL) {
            throw new RuntimeException("Configuration changed! Expected 3h interval");
        }

        List<HourlyWeather> results = new ArrayList<>();
        results.add(createHourly("00:00", hourlyForecasts.get(0)));
        results.add(createHourly("06:00", hourlyForecasts.get(2)));
        results.add(createHourly("12:00", hourlyForecasts.get(4)));
        results.add(createHourly("18:00", hourlyForecasts.get(6)));
        results.add(createHourly("21:00", hourlyForecasts.get(7)));

        return results;

    }

    private HourlyWeather createHourly(String time, Hourly hourly) {
        HourlyWeather hourWeather = new HourlyWeather();
        hourWeather.setTime(toTime(time));
        hourWeather.setTemperature(hourly.getTempC());
        return hourWeather;
    }

    private DateTime toTime(String date) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(TIME_ONLY_PATTERN);
        return formatter.parseDateTime(date);
    }
}
