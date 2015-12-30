package aethernadev.com.weatherprovider.mapper;

import java.util.List;

import javax.inject.Inject;

import aethernadev.com.weatherprovider.model.SingleValue;
import aethernadev.com.weatherprovider.model.searchlocation.ResponseLocation;

/**
 * Created by Aetherna on 2015-12-27.
 */
public class SingleValuesToStringConverter {

    private static final String EMPTY_STRING = "";

    @Inject
    public SingleValuesToStringConverter() {
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
