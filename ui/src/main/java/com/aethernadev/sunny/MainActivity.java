package com.aethernadev.sunny;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

import com.aethernadev.sunny.main.firstlaunch.FirstInitPresenter;
import com.aethernadev.sunny.settings.SettingsActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;


public class MainActivity extends ActionBarActivity implements FirstInitPresenter.UI {

    @Inject
    FirstInitPresenter firstInitPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((SunnyApp) getApplication()).getAppComponent().inject(this);
        ButterKnife.bind(this, this);

        firstInitPresenter.attachUI(this);
        firstInitPresenter.initOnFirstLaunch();


        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showLoading() {
        Log.d("loading", "loading");
    }

    @Override
    public void startApplication() {
        Log.d("launch the rest uff", "dasdsa");
    }

}
