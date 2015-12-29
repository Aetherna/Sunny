package com.aethernadev.storage.location;

import com.aethernadev.sunny.data.Location;

import javax.inject.Inject;

/**
 * Created by Aetherna on 2015-12-29.
 */
public class RealmLocationMapper {

    private static final String EMPTY = "";

    @Inject
    public RealmLocationMapper() {
    }

    public void mapToRealm(Location location, RealmLocation realmLocation) {
        if (location == null || realmLocation == null) {
            throw new RuntimeException("Location nor realmLocation can't be nulls!");
        }
        realmLocation.setName(format(location.getName()));
        realmLocation.setRegion(format(location.getRegion()));
        realmLocation.setCountry(format(location.getCountry()));
        realmLocation.setLatitude(location.getLatitude());
        realmLocation.setLongitude(location.getLongitude());

    }

    /**
     * @return value or empty string if value is null or empty
     */
    private String format(String value) {
        if (value == null || value.trim().isEmpty()) {
            return EMPTY;
        }
        return value;
    }

    public Location mapToLocation(RealmLocation realmLocation) {
        if (realmLocation == null) {
            throw new RuntimeException("RealmLocation can not be null!");
        }
        Location location = new Location();
        location.setName(realmLocation.getName());
        location.setRegion(realmLocation.getRegion());
        location.setCountry(realmLocation.getCountry());
        location.setLatitude(realmLocation.getLatitude());
        location.setLongitude(realmLocation.getLongitude());
        return location;
    }
}
