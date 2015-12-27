package com.aethernadev.sunny;

import java.util.List;

import rx.Observable;

/**
 * Created by Aetherna on 2015-12-27.
 */
public interface WeatherDao {

    Observable<List<Location>> findAvailableLocations(String locationName);
}
