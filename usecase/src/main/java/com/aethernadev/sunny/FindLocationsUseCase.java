package com.aethernadev.sunny;

import com.aethernadev.sunny.base.UseCase;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class FindLocationsUseCase implements UseCase<List<Location>, String> {

    WeatherDao weatherDao;

    @Inject
    public FindLocationsUseCase(WeatherDao weatherDao) {
        this.weatherDao = weatherDao;
    }

    @Override
    public Observable<List<Location>> execute(String locationName) {
        return weatherDao.findAvailableLocations(locationName);
    }
}
