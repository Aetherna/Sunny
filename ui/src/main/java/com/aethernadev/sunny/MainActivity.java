package com.aethernadev.sunny;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.aethernadev.sunny.main.WeatherPagerAdapter;
import com.aethernadev.sunny.main.firstlaunch.FirstInitPresenter;
import com.aethernadev.sunny.settings.SettingsActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements FirstInitPresenter.UI {

    protected WeatherPagerAdapter weatherPagesAdapter;
    @Bind(R.id.container)
    protected ViewPager viewPager;
    @Bind(R.id.tabLayout)
    protected TabLayout tabLayout;

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
    }

    @Override
    public void showLoading() {
        Log.d("loading", "loading");
    }

    @Override
    public void startApplication() {
        weatherPagesAdapter = new WeatherPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(weatherPagesAdapter);

        tabLayout.setTabsFromPagerAdapter(weatherPagesAdapter);
        tabLayout.setupWithViewPager(viewPager);
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
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
