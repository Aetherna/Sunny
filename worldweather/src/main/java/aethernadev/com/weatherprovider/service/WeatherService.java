package aethernadev.com.weatherprovider.service;

import java.util.Map;

import aethernadev.com.weatherprovider.model.searchlocation.SearchLocationResponse;
import aethernadev.com.weatherprovider.model.weatherforecast.WeatherForecastResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.QueryMap;
import rx.Observable;

/**
 * Created by Aetherna.
 */
public interface WeatherService {

    @GET("/premium/v1/search.ashx")
    Observable<SearchLocationResponse> searchLocation(@QueryMap Map<String, String> options);

    @GET("/premium/v1/weather.ashx")
    Observable<WeatherForecastResponse> getWeatherForecast(@QueryMap Map<String, String> options);
}
