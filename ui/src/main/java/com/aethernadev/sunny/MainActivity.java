package com.aethernadev.sunny;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.aethernadev.sunny.data.Location;
import com.aethernadev.sunny.main.MainPresenter;
import com.aethernadev.sunny.main.WeatherPagerAdapter;
import com.aethernadev.sunny.main.firstlaunch.FirstInitPresenter;
import com.aethernadev.sunny.settings.SettingsActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements FirstInitPresenter.UI, MainPresenter.UI {

    protected WeatherPagerAdapter weatherPagesAdapter;
    @Bind(R.id.container)
    protected ViewPager viewPager;
    @Bind(R.id.tabLayout)
    protected TabLayout tabLayout;

    @Inject
    FirstInitPresenter firstInitPresenter;
    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((SunnyApp) getApplication()).getAppComponent().inject(this);
        ButterKnife.bind(this, this);

        firstInitPresenter.attachUI(this);
        mainPresenter.attachUI(this);
        firstInitPresenter.initOnFirstLaunch();
    }

    @Override
    public void showLoading() {
        Log.d("loading", "loading");
    }

    @Override
    public void startApplication() {
        mainPresenter.loadUserSettings();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivityForResult(intent, 0);
        } else if (id == R.id.action_refersh) {
            mainPresenter.loadUserSettings();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showLocationsForecast(List<Location> locations) {

        if (locations.isEmpty()) {
            Snackbar.make(tabLayout, R.string.no_cites_chosen, Snackbar.LENGTH_INDEFINITE).show();
        }

        weatherPagesAdapter = new WeatherPagerAdapter(getSupportFragmentManager(), locations);
        viewPager.setAdapter(weatherPagesAdapter);

        tabLayout.setTabsFromPagerAdapter(weatherPagesAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == SettingsActivity.CHANGED_SETTINGS) {
            mainPresenter.loadUserSettings();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainPresenter.detachUI();
        firstInitPresenter.detachUI();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.attachUI(this);
        firstInitPresenter.attachUI(this);
    }

}
