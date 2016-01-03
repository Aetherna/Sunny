package aethernadev.com.weatherprovider.mapper;

import com.aethernadev.sunny.data.Location;
import com.google.common.truth.Truth;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aetherna.
 */
public class QueryCoordinatesTest {

    private QueryCoordinates testObject;


    @Before
    public void setUp() throws Exception {
        testObject = new QueryCoordinates();
    }

    @Test
    public void testFrom() throws Exception {
        //having
        Location testLocation = new Location();
        testLocation.setLatitude(12345.67);
        testLocation.setLongitude(98765.43);

        //when
        String stringCoordinates = testObject.from(testLocation);

        //then
        Truth.assertThat(stringCoordinates).isEqualTo("12345.67,98765.43");

    }
}