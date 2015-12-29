package com.aethernadev.sunny.settings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.widget.FrameLayout;

import com.aethernadev.sunny.R;
import com.aethernadev.sunny.settings.cities.SettingsCitiesFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SettingsActivity extends ActionBarActivity {

    @Bind(R.id.content)
    FrameLayout layout;

    private SettingsCitiesFragment citiesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this, this);

        initSettingsFragment(savedInstanceState);
    }

    private void initSettingsFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            citiesFragment = SettingsCitiesFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, citiesFragment, SettingsCitiesFragment.class.getName())
                    .commit();
        } else {
            citiesFragment = (SettingsCitiesFragment) (getSupportFragmentManager().findFragmentByTag(SettingsCitiesFragment.class.getName()));
        }
    }

}
