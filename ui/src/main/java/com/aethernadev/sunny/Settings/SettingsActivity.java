package com.aethernadev.sunny.settings;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.aethernadev.sunny.R;
import com.aethernadev.sunny.SunnyApp;
import com.aethernadev.sunny.presenter.settings.SettingsMainPresenter;
import com.aethernadev.sunny.settings.cities.SettingsCitiesFragment;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends AppCompatActivity implements SettingsMainPresenter.UI {

    public static final int CHANGED_SETTINGS = 9999;
    @Bind(R.id.content)
    FrameLayout layout;

    @Inject
    SettingsMainPresenter presenter;

    private SettingsCitiesFragment citiesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this, this);
        ((SunnyApp) getApplication()).getAppComponent().inject(this);

        presenter.attachUI(this);

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

    @OnClick(R.id.cancel_settings)
    public void cancel(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    @OnClick(R.id.save_settings)
    public void save(View view) {
        presenter.saveSettings(citiesFragment.getUserSelectedLocations());
    }

    @Override
    public void closeSettings() {
        Snackbar.make(layout, R.string.settings_saved, Snackbar.LENGTH_SHORT).show();
        setResult(CHANGED_SETTINGS);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachUI(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.detachUI();
    }
}
