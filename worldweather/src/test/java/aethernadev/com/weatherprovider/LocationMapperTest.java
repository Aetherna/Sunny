package aethernadev.com.weatherprovider;

import com.aethernadev.sunny.Location;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import aethernadev.com.weatherprovider.mapper.LocationMapper;
import aethernadev.com.weatherprovider.mapper.SingleValuesToStringConverter;
import aethernadev.com.weatherprovider.model.searchlocation.ResponseLocation;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by Aetherna on 2015-12-27.
 */
public class LocationMapperTest {

    @Mock
    SingleValuesToStringConverter converter;
    LocationMapper testObject;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testObject = new LocationMapper(converter);
    }

    @Test
    public void shouldNotReturnNullOnNullResponse() {
        //having
        //when
        Location result = testObject.mapFrom(null);
        //then
        assertThat(result).isNotNull();
    }

    @Test
    public void shouldNotReturnNullOnEmptyResponse() {
        //having
        ResponseLocation response = new ResponseLocation();
        //when
        Location result = testObject.mapFrom(response);
        //then
        assertThat(result).isNotNull();
    }

    @Test
    public void shouldMapProperly() {

        //having
        Mockito.when(converter.convertToString(null)).thenReturn("SomeValue");

        ResponseLocation response = new ResponseLocation();
        response.setLatitude(1000.0);
        response.setLongitude(2000.0);

        //when
        Location result = testObject.mapFrom(response);

        //then
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("SomeValue");
        assertThat(result.getLatitude()).isEqualTo(1000.0);
        assertThat(result.getLongitude()).isEqualTo(2000.0);

    }
}
