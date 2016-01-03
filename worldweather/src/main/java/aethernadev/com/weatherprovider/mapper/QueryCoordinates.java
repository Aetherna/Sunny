package aethernadev.com.weatherprovider.mapper;

import android.text.TextUtils;

import com.aethernadev.sunny.data.Location;

import javax.inject.Inject;

/**
 * Created by Aetherna.
 */
public class QueryCoordinates {

    private static final CharSequence DELIMITER = ",";

    @Inject
    public QueryCoordinates() {
    }

    public String from(Location location) {

        if (location == null) {
            throw new RuntimeException("Location can not be null!");
        }
        return Double.toString(location.getLatitude()) + DELIMITER + Double.toString(location.getLongitude());
    }

}
