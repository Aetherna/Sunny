package com.aethernadev.sunny.searchlocation;

import com.aethernadev.sunny.base.UseCase;
import com.aethernadev.sunny.dao.WeatherDao;
import com.aethernadev.sunny.data.Location;

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
