package aethernadev.com.weatherprovider.mapper.forecast;

import com.aethernadev.sunny.data.CurrentConditions;

import javax.inject.Inject;

import aethernadev.com.weatherprovider.mapper.SingleValueToString;
import aethernadev.com.weatherprovider.model.weatherforecast.WeatherForecast;
import aethernadev.com.weatherprovider.model.weatherforecast.currentcondition.CurrentCondition;

/**
 * Created by Aetherna.
 */
public class CurrentConditionsMapper {

    private SingleValueToString converter;

    @Inject
    public CurrentConditionsMapper(SingleValueToString converter) {
        this.converter = converter;
    }

    public CurrentConditions from(WeatherForecast weatherForecast) {

        if (weatherForecast.getCurrentConditions() == null || weatherForecast.getCurrentConditions().isEmpty()) {
            throw new RuntimeException("WeatherForecast can not be empty!");
        }

        CurrentCondition sourceCondition = weatherForecast.getCurrentConditions().get(0);

        CurrentConditions conditions = new CurrentConditions();
        conditions.setPressure(sourceCondition.getPressure());
        conditions.setTemperatureNowCelsius(sourceCondition.getTempInC());
        conditions.setWeatherDescription(converter.convertToString(sourceCondition.getWeatherDesc()));

        return conditions;
    }
}
