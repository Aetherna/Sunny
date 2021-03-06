package aethernadev.com.weatherprovider.mapper;

import com.aethernadev.sunny.data.Location;

import javax.inject.Inject;

import aethernadev.com.weatherprovider.model.searchlocation.ResponseLocation;

/**
 * Created by Aetherna.
 */
public class LocationMapper {

    SingleValueToString converter;

    @Inject
    public LocationMapper(SingleValueToString converter) {
        this.converter = converter;
    }

    public Location mapFrom(ResponseLocation responseLocation) {

        Location location = new Location();

        if (responseLocation == null) {
            return location;
        }

        location.setName(converter.convertToString(responseLocation.getName()));
        location.setRegion(converter.convertToString(responseLocation.getRegion()));
        location.setCountry(converter.convertToString(responseLocation.getCountry()));
        location.setLatitude(responseLocation.getLatitude());
        location.setLongitude(responseLocation.getLongitude());

        return location;
    }

}
