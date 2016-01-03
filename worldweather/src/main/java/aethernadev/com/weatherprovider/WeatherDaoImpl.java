package aethernadev.com.weatherprovider;

import android.support.annotation.NonNull;

import com.aethernadev.sunny.data.Forecast;
import com.aethernadev.sunny.data.Location;
import com.aethernadev.sunny.dao.WeatherDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import aethernadev.com.weatherprovider.mapper.LocationMapper;
import aethernadev.com.weatherprovider.mapper.QueryCoordinates;
import aethernadev.com.weatherprovider.mapper.forecast.ForecastMapper;
import aethernadev.com.weatherprovider.model.searchlocation.ResponseLocation;
import aethernadev.com.weatherprovider.model.searchlocation.SearchLocationResponse;
import aethernadev.com.weatherprovider.model.searchlocation.SearchResult;
import aethernadev.com.weatherprovider.model.weatherforecast.WeatherForecastResponse;
import aethernadev.com.weatherprovider.service.WeatherService;
import retrofit.Retrofit;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Aetherna on 2015-12-26.
 */
public class WeatherDaoImpl implements WeatherDao {

    private final static String API_KEY = "key";
    private final static String QUERY = "q";
    private final static String RESPONSE_FORMAT_KEY = "format";
    private final static String JSON_RESPONSE_FORMAT = "JSON";
    private final static String NUM_OF_RESULTS_KEY = "num_of_results";
    private final static String MAX_NUM_OF_RESULTS = "30";
    private final static String NUM_OF_DAYS_KEY = "num_of_days";
    private final static String NUM_OF_DAYS = "5";

    private WeatherService weatherService;
    private final LocationMapper locationMapper;
    private final ForecastMapper forecastMapper;
    private QueryCoordinates queryCoordinates;

    @Inject
    public WeatherDaoImpl(Retrofit retrofit, LocationMapper locationMapper, ForecastMapper forecastMapper, QueryCoordinates queryCoordinates) {
        this.locationMapper = locationMapper;
        this.forecastMapper = forecastMapper;
        this.queryCoordinates = queryCoordinates;
        this.weatherService = retrofit.create(WeatherService.class);
    }

    @Override
    public Observable<List<Location>> findAvailableLocations(final String locationName) {
        Map<String, String> queryArguments = new HashMap<>(); //todo
        queryArguments.put(API_KEY, "239fd36834e8ad762c8dca32c7f42");
        queryArguments.put(RESPONSE_FORMAT_KEY, JSON_RESPONSE_FORMAT);
        queryArguments.put(NUM_OF_RESULTS_KEY, MAX_NUM_OF_RESULTS);
        queryArguments.put(QUERY, locationName);

        return weatherService.searchLocation(queryArguments).map(new Func1<SearchLocationResponse, List<Location>>() {
            @Override
            public List<Location> call(SearchLocationResponse searchLocationResponse) {

                return searchResultToLocations(searchLocationResponse);
            }
        });
    }

    @NonNull
    private List<Location> searchResultToLocations(SearchLocationResponse searchLocationResponse) {
        SearchResult searchResult = searchLocationResponse.getSearchResult();
        List<Location> locations = new ArrayList<>();

        if (searchResult == null) {
            return locations;
        }
        for (ResponseLocation responseLocation : searchResult.getLocations()) {
            locations.add(locationMapper.mapFrom(responseLocation));
        }

        return locations;
    }

    @Override
    public Observable<Forecast> getForecast(Location location) {
        Map<String, String> queryArguments = new HashMap<>();
        queryArguments.put(API_KEY, "239fd36834e8ad762c8dca32c7f42"); //todo
        queryArguments.put(RESPONSE_FORMAT_KEY, JSON_RESPONSE_FORMAT);
        queryArguments.put(NUM_OF_DAYS_KEY, NUM_OF_DAYS);
        queryArguments.put(QUERY, queryCoordinates.from(location));

        return weatherService.getWeatherForecast(queryArguments).map(new Func1<WeatherForecastResponse, Forecast>() {
            @Override
            public Forecast call(WeatherForecastResponse weatherForecastResponse) {
                return forecastMapper.from(weatherForecastResponse);
            }
        });
    }

}
