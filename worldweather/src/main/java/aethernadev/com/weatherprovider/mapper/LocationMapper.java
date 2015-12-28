package aethernadev.com.weatherprovider.mapper;

import com.aethernadev.sunny.Location;

import javax.inject.Inject;

import aethernadev.com.weatherprovider.model.searchlocation.ResponseLocation;

/**
 * Created by Aetherna on 2015-12-27.
 */
public class LocationMapper {

    SingleValuesToStringConverter converter;

    @Inject
    public LocationMapper(SingleValuesToStringConverter converter) {
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
