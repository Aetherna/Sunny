package com.aethernadev.sunny;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import com.aethernadev.sunny.dagger.AppComponent;
import com.aethernadev.sunny.dagger.DaggerAppComponent;
import com.aethernadev.sunny.dagger.DaggerWeatherComponent;
import com.aethernadev.sunny.dagger.WeatherComponent;
import com.aethernadev.sunny.settings.SettingsActivity;
import com.aethernadev.sunny.settings.SettingsCitiesPresenter;

import javax.inject.Inject;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

    }

}
