package com.aethernadev.sunny.main.forecast;

import com.aethernadev.sunny.base.UseCase;
import com.aethernadev.sunny.dao.WeatherDao;
import com.aethernadev.sunny.data.Forecast;
import com.aethernadev.sunny.data.Location;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class GetForecastUseCase implements UseCase<Forecast, Location> {

    private WeatherDao weatherDao;

    @Inject
    public GetForecastUseCase(WeatherDao weatherDao) {
        this.weatherDao = weatherDao;
    }

    @Override
    public Observable<Forecast> execute(Location location) {
        return weatherDao.getForecast(location);
    }
}
