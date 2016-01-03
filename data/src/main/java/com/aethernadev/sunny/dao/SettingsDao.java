package com.aethernadev.sunny.dao;

import com.aethernadev.sunny.data.Location;

import java.util.List;

/**
 * Created by Aetherna.
 */
public interface SettingsDao {

    boolean saveUserLocations(List<Location> locations);

    List<Location> getUserLocations();

    void deleteOldUserLocations();
}
