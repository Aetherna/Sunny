package aethernadev.com.weatherprovider;

import android.test.AndroidTestCase;

import com.aethernadev.sunny.data.Location;

import junit.framework.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import aethernadev.com.weatherprovider.mapper.QueryCoordinates;
import aethernadev.com.weatherprovider.model.weatherforecast.WeatherForecast;
import aethernadev.com.weatherprovider.model.weatherforecast.WeatherForecastResponse;
import aethernadev.com.weatherprovider.service.WeatherService;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.http.GET;
import retrofit.http.QueryMap;
import rx.Observable;
import rx.Observer;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class WeatherServiceTest extends AndroidTestCase {

    private QueryCoordinates queryCoordinates;
    private TestWeatherService weatherService;
    private ObservableWeatherService observableWeatherService;

    public void setUp() throws Exception {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.worldweatheronline.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        this.queryCoordinates = new QueryCoordinates();
        this.weatherService = retrofit.create(TestWeatherService.class);
        this.observableWeatherService = retrofit.create(ObservableWeatherService.class);
    }

    public void testResponseObjectAreCorrect() {

        Location location = new Location();
        location.setLongitude(-6.249);
        location.setLatitude(53.333);

        Map<String, String> queryArguments = new HashMap<>();
        queryArguments.put("key", BuildConfig.WEATHER_API_KEY);
        queryArguments.put("format", "JSON");
        queryArguments.put("num_of_days", "5");
        queryArguments.put("q", queryCoordinates.from(location));

        try {
            Response<WeatherForecastResponse> response = weatherService.getWeatherForecast(queryArguments).execute();

            assertNotNull(response.body());
            WeatherForecast weatherForecast = response.body().getWeatherForecast();
            assertNotNull(weatherForecast);
            assertNotNull(weatherForecast.getClimateAverages());
            assertTrue(!weatherForecast.getClimateAverages().isEmpty());
            assertNotNull(weatherForecast.getCurrentConditions());
            assertNotNull(weatherForecast.getRequest());
            assertNotNull(weatherForecast.getDaysForecasts());
            assertEquals(5, weatherForecast.getDaysForecasts().size());

        } catch (IOException e) {
            Assert.fail();
            e.printStackTrace();
        }
    }

    public void testResponseObjectWorksWithObservable() {

        Location location = new Location();
        location.setLongitude(-6.249);
        location.setLatitude(53.333);

        Map<String, String> queryArguments = new HashMap<>();
        queryArguments.put("key", BuildConfig.WEATHER_API_KEY);
        queryArguments.put("format", "JSON");
        queryArguments.put("num_of_days", "5");
        queryArguments.put("q", queryCoordinates.from(location));

        observableWeatherService.getWeatherForecast(queryArguments).subscribe(new Observer<WeatherForecastResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Assert.fail();
            }

            @Override
            public void onNext(WeatherForecastResponse forecastResponse) {
                assertNotNull(forecastResponse);
                WeatherForecast weatherForecast = forecastResponse.getWeatherForecast();
                assertNotNull(weatherForecast);
                assertNotNull(weatherForecast.getClimateAverages());
                assertTrue(!weatherForecast.getClimateAverages().isEmpty());
                assertNotNull(weatherForecast.getCurrentConditions());
                assertNotNull(weatherForecast.getRequest());
                assertNotNull(weatherForecast.getDaysForecasts());
                assertEquals(5, weatherForecast.getDaysForecasts().size());

            }
        });
    }

    interface TestWeatherService {

        @GET("/premium/v1/weather.ashx")
        Call<WeatherForecastResponse> getWeatherForecast(@QueryMap Map<String, String> options);
    }

    interface ObservableWeatherService {

        @GET("/premium/v1/weather.ashx")
        Observable<WeatherForecastResponse> getWeatherForecast(@QueryMap Map<String, String> options);
    }


}
