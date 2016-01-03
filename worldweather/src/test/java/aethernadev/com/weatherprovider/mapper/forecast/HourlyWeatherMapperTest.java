package aethernadev.com.weatherprovider.mapper.forecast;

import com.aethernadev.sunny.data.HourlyWeather;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import aethernadev.com.weatherprovider.mapper.forecast.dayweather.HourlyWeatherMapper;
import aethernadev.com.weatherprovider.model.weatherforecast.weather.Hourly;

import static org.junit.Assert.*;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class HourlyWeatherMapperTest {
    HourlyWeatherMapper testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new HourlyWeatherMapper();
    }

    @Test
    public void testFrom() throws Exception {

        //having proper data
        List<Hourly> responseData = new ArrayList<>();
        for(int i = 0; i< 8; i++){
            Hourly hourly = new Hourly();
            hourly.setTempC(i);
            responseData.add(hourly);
        }

        //when
        List<HourlyWeather> result = testObject.from(responseData);

        //then
        Assert.assertNotNull(result);
        Assert.assertEquals(5, result.size());

        for(HourlyWeather hourly: result){
            assertNotNull(hourly.getTime());
        }

        assertEquals(0,result.get(0).getTime().getHourOfDay());
        assertEquals(6,result.get(1).getTime().getHourOfDay());
        assertEquals(12,result.get(2).getTime().getHourOfDay());
        assertEquals(18,result.get(3).getTime().getHourOfDay());
        assertEquals(21, result.get(4).getTime().getHourOfDay());

    }
}