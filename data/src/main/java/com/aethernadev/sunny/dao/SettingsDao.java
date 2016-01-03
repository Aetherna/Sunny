package com.aethernadev.sunny.dao;

import com.aethernadev.sunny.data.Location;

import java.util.List;

/**
 * Created by Aetherna on 2015-12-29.
 */
public interface SettingsDao {

    boolean saveUserLocations(List<Location> locations);

    List<Location> getUserLocations();

    void deleteOldUserLocations();
}
