package aethernadev.com.weatherprovider.module;

import com.aethernadev.sunny.dao.WeatherDao;

import javax.inject.Singleton;

import aethernadev.com.weatherprovider.WeatherDaoImpl;
import aethernadev.com.weatherprovider.mapper.LocationMapper;
import aethernadev.com.weatherprovider.mapper.QueryCoordinates;
import aethernadev.com.weatherprovider.mapper.forecast.ForecastMapper;
import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Aetherna on 2015-12-26.
 */

@Module
public class RetrofitModule {

    @Singleton
    @Provides
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.worldweatheronline.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


    @Singleton
    @Provides
    public WeatherDao provideWeatherSource(Retrofit retrofit, LocationMapper mapper, ForecastMapper forecastMapper, QueryCoordinates queryCoordinates) {
        return new WeatherDaoImpl(retrofit, mapper, forecastMapper, queryCoordinates);
    }
}
