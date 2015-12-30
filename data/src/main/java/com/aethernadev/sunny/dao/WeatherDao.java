package com.aethernadev.sunny.dao;

import com.aethernadev.sunny.data.Forecast;
import com.aethernadev.sunny.data.Location;

import java.util.List;

import rx.Observable;

/**
 * Created by Aetherna on 2015-12-27.
 */
public interface WeatherDao {

    Observable<List<Location>> findAvailableLocations(String locationName);

    Observable<Forecast> getForecast(Location location);
}
