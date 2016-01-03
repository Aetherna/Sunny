package com.aethernadev.sunny.presenter.main.firstlaunch;

import android.content.SharedPreferences;

import com.aethernadev.sunny.presenter.base.BasePresenter;
import com.aethernadev.sunny.presenter.base.UIAction;
import com.aethernadev.sunny.base.UseCaseExecutor;
import com.aethernadev.sunny.data.Location;
import com.aethernadev.sunny.settings.SaveUserSettingsUseCase;

import java.util.List;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by Aetherna.
 */
public class FirstInitPresenter extends BasePresenter<FirstInitPresenter.UI> {

    public static final String FIRST_LAUNCH_KEY = "firstLaunchKey";

    SaveUserSettingsUseCase saveUserSettingsUseCase;
    UseCaseExecutor executor;
    SharedPreferences preferences;
    DefaultSettings defaultSettings;

    @Inject
    public FirstInitPresenter(SaveUserSettingsUseCase saveUserSettingsUseCase, UseCaseExecutor executor, SharedPreferences preferences, DefaultSettings defaultSettings) {
        this.saveUserSettingsUseCase = saveUserSettingsUseCase;
        this.executor = executor;
        this.preferences = preferences;
        this.defaultSettings = defaultSettings;
    }

   public void initOnFirstLaunch() {
        showLoading();

        if (isFirstLaunch()) {
            initDefaultSettings();
        } else {
            startApplication();
        }
    }


    private void showLoading() {
        execute(new UIAction<UI>() {
            @Override
            public void execute(UI ui) {
                ui.showLoading();
            }
        });
    }

    private void initDefaultSettings() {

        List<Location> defaultLocations = defaultSettings.getLocations();

        executor.wrap(saveUserSettingsUseCase, defaultLocations)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        setFirstInitFlagFalse();
                        startApplication();
                    }
                });
    }

    private void startApplication() {
        execute(new UIAction<UI>() {
            @Override
            public void execute(UI ui) {
                ui.startApplication();
            }
        });
    }

    private boolean isFirstLaunch() {
        return preferences.getBoolean(FIRST_LAUNCH_KEY, true);
    }

    private void setFirstInitFlagFalse() {
        preferences.edit().putBoolean(FIRST_LAUNCH_KEY, false).apply();
    }

    public interface UI {
        void showLoading();

        void startApplication();
    }
}
