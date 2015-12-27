package com.aethernadev.sunny;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

import com.aethernadev.sunny.dagger.DaggerWeatherComponent;
import com.aethernadev.sunny.dagger.WeatherComponent;

import java.util.List;

import javax.inject.Inject;

import aethernadev.com.weatherprovider.WeatherDaoImpl;
import aethernadev.com.weatherprovider.model.searchlocation.SearchLocationResponse;
import aethernadev.com.weatherprovider.model.searchlocation.SearchResult;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends ActionBarActivity {

    @Inject
    WeatherDaoImpl weatherSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherComponent appComponent = DaggerWeatherComponent.builder().build();
        appComponent.inject(this);


        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherSource.findAvailableLocations("London").subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<List<Location>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                            }

                            @Override
                            public void onNext(List<Location> locations) {
                                locations.size();
                            }
                        });
            }
        });

    }
}
