package com.aethernadev.sunny.presenter.settings;

import android.util.Log;

import com.aethernadev.sunny.base.UseCaseExecutor;
import com.aethernadev.sunny.data.Location;
import com.aethernadev.sunny.presenter.base.BasePresenter;
import com.aethernadev.sunny.presenter.base.UIAction;
import com.aethernadev.sunny.presenter.error.PrintableError;
import com.aethernadev.sunny.presenter.error.SunnyError;
import com.aethernadev.sunny.presenter.error.UnknownError;
import com.aethernadev.sunny.searchlocation.FindLocationsUseCase;
import com.aethernadev.sunny.settings.GetUserSettingsUseCase;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.functions.Action1;

/**
 * Created by Aetherna.
 */
public class SettingsCitiesPresenter extends BasePresenter<SettingsCitiesPresenter.SettingsUI> {

    private static final int SINGLE_RESULT = 1;
    private FindLocationsUseCase findLocationsUseCase;
    private GetUserSettingsUseCase getUserSettings;
    private UseCaseExecutor executor;

    private List<Location> selectedLocations;

    @Inject
    public SettingsCitiesPresenter(FindLocationsUseCase findLocationsUseCase, GetUserSettingsUseCase getUserSettings, UseCaseExecutor useCaseExecutor) {
        this.findLocationsUseCase = findLocationsUseCase;
        this.getUserSettings = getUserSettings;
        this.executor = useCaseExecutor;
        this.selectedLocations = new ArrayList<>();
    }

    public void onLocationSearch(final String location) {

        showLoading();

        executor.wrap(findLocationsUseCase, location)
                .subscribe(new Observer<List<Location>>() {
                    @Override
                    public void onCompleted() {
                        hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                        if (e instanceof UnknownHostException) {
                            showError(SunnyError.CONNECTION_ERROR);
                        } else {
                            Log.e(SettingsCitiesPresenter.class.getSimpleName(),"Error finding locations:" + e.getMessage());
                            showError(new UnknownError(e));
                        }
                    }

                    @Override
                    public void onNext(List<Location> locations) {
                        hideLoading();
                        if (locations.isEmpty()) {
                            showError(SunnyError.NO_RESULTS);
                        } else if (SINGLE_RESULT == locations.size()) {
                            addFirstLocation(locations);
                        } else {
                            selectLocation(locations);
                        }
                    }
                });
    }

    private void addFirstLocation(List<Location> locations) {
        final Location locationToAdd = locations.get(0);
        selectedLocations.add(locationToAdd);
        uiAddLocation(locationToAdd);
        hideError();
    }


    private void selectLocation(final List<Location> locations) {
        execute(new UIAction<SettingsUI>() {
            @Override
            public void execute(SettingsUI settingsUI) {
                ui.selectOneFromLocations(locations);
            }
        });
    }

    private void uiAddLocation(final Location locationToAdd) {
        execute(new UIAction<SettingsUI>() {
            @Override
            public void execute(SettingsUI settingsUI) {
                ui.addLocation(locationToAdd);
            }
        });
    }

    private void showError(final PrintableError error) {
        execute(new UIAction<SettingsUI>() {
            @Override
            public void execute(SettingsUI settingsUI) {
                ui.showError(error);
            }
        });
    }

    private void hideError() {
        execute(new UIAction<SettingsUI>() {
            @Override
            public void execute(SettingsUI settingsUI) {
                ui.hideError();
            }
        });
    }

    private void showLoading() {
        execute(new UIAction<SettingsUI>() {
            @Override
            public void execute(SettingsUI settingsUI) {
                ui.showLoading();
            }
        });
    }

    private void hideLoading() {
        execute(new UIAction<SettingsUI>() {
            @Override
            public void execute(SettingsUI settingsUI) {
                ui.hideLoading();
            }
        });
    }

    public void onRemoveLocation(Location location) {
        selectedLocations.remove(location);
    }

    public List<Location> getSelectedLocations() {
        return selectedLocations;
    }

    public void setSelectedLocations(final List<Location> selectedLocations) {
        this.selectedLocations = selectedLocations;
        execute(new UIAction<SettingsUI>() {
            @Override
            public void execute(SettingsUI settingsUI) {
                ui.setLocations(selectedLocations);
            }
        });
    }

    public void loadSavedLocations() {

        executor.wrap(getUserSettings, null)
                .subscribe(new Action1<List<Location>>() {
                    @Override
                    public void call(List<Location> locations) {
                        setSelectedLocations(locations);
                    }
                });
    }

    public void addSelectedLocation(Location location) {
        this.selectedLocations.add(location);
        uiAddLocation(location);
    }

    public interface SettingsUI {
        void addLocation(Location location);

        void setLocations(List<Location> locations);

        void showError(PrintableError error);

        void showLoading();

        void hideLoading();

        void hideError();

        void selectOneFromLocations(List<Location> locations);
    }
}
