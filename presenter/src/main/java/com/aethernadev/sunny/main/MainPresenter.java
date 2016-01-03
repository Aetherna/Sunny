package com.aethernadev.sunny.main;

import com.aethernadev.sunny.base.BasePresenter;
import com.aethernadev.sunny.base.UIAction;
import com.aethernadev.sunny.base.UseCaseExecutor;
import com.aethernadev.sunny.data.Location;
import com.aethernadev.sunny.settings.GetUserSettingsUseCase;

import java.util.List;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by Aetherna on 2015-12-28.
 */
public class MainPresenter extends BasePresenter<MainPresenter.UI> {

    private GetUserSettingsUseCase getUserSettings;
    private UseCaseExecutor executor;

    @Inject
    public MainPresenter(GetUserSettingsUseCase getUserSettings, UseCaseExecutor executor) {
        this.getUserSettings = getUserSettings;
        this.executor = executor;
    }

    public void loadUserSettings() {
        executor.wrap(getUserSettings, null).subscribe(new Action1<List<Location>>() {
            @Override
            public void call(List<Location> locations) {
                showLocationsForecasts(locations);
            }
        });
    }

    private void showLocationsForecasts(final List<Location> locations) {
        execute(new UIAction<UI>() {
            @Override
            public void execute(UI ui) {
                ui.showLocationsForecast(locations);
            }
        });
    }

    public interface UI {
        void showLocationsForecast(List<Location> locations);
    }
}
