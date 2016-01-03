package aethernadev.com.weatherprovider.mapper;

import java.util.List;

import javax.inject.Inject;

import aethernadev.com.weatherprovider.model.SingleValue;
import aethernadev.com.weatherprovider.model.searchlocation.ResponseLocation;

/**
 * Created by Aetherna.
 */
public class SingleValueToString {

    private static final String EMPTY_STRING = "";

    @Inject
    public SingleValueToString() {
    }

    public String convertToString(List<SingleValue> singleValues) {
        if (singleValues == null || singleValues.isEmpty()) {
            return EMPTY_STRING;
        }

        if (singleValues.get(0) == null || singleValues.get(0).getValue() == null) {
            return EMPTY_STRING;
        }
        return singleValues.get(0).getValue();
    }
}
