package com.aethernadev.sunny.settings;

import com.aethernadev.sunny.FindLocationsUseCase;
import com.aethernadev.sunny.GetDefaultSettingsUseCase;
import com.aethernadev.sunny.GetUserSettingsUseCase;
import com.aethernadev.sunny.data.Location;
import com.aethernadev.sunny.base.BasePresenter;
import com.aethernadev.sunny.base.UIAction;
import com.aethernadev.sunny.base.UseCaseExecutor;
import com.aethernadev.sunny.usecaseexecutor.AsyncUseCaseExecutor;

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
    private GetDefaultSettingsUseCase getDefaultSettings;
    private GetUserSettingsUseCase getUserSettings;
    private UseCaseExecutor executor;

    private List<Location> selectedLocations;

    @Inject
    public SettingsCitiesPresenter(FindLocationsUseCase findLocationsUseCase, GetDefaultSettingsUseCase getDefaultSettings, GetUserSettingsUseCase getUserSettings, AsyncUseCaseExecutor useCaseExecutor) {
        this.findLocationsUseCase = findLocationsUseCase;
        this.getDefaultSettings = getDefaultSettings;
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
                        showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Location> locations) {
                        if (locations.isEmpty()) {
                            hideLoading();
                            showError("No location found!");
                            return;
                        }

                        if (locations.size() == SINGLE_RESULT) {
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

    private void showError(final String errorMessage) {
        execute(new UIAction<SettingsUI>() {
            @Override
            public void execute(SettingsUI settingsUI) {
                ui.showError(errorMessage);
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

    public void loadSavedLocations() {

        executor.wrap(getUserSettings, null)
                .subscribe(new Action1<List<Location>>() {
                    @Override
                    public void call(List<Location> locations) {
                        if (locations.isEmpty()) {
                            loadDefaultLocations();
                        } else {
                            setSelectedLocations(locations);
                        }
                    }
                });
    }

    private void loadDefaultLocations() {
        executor.wrap(getDefaultSettings, null)
                .subscribe(new Action1<List<Location>>() {
                    @Override
                    public void call(List<Location> locations) {
                        setSelectedLocations(locations);
                    }
                });
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

    public void addSelectedLocation(Location location) {
        this.selectedLocations.add(location);
        uiAddLocation(location);
    }

    public interface SettingsUI {
        void addLocation(Location location);

        void setLocations(List<Location> locations);

        void showError(String error); //todo try use resource id from presenter layer:>

        void showLoading();

        void hideLoading();

        void hideError();

        void selectOneFromLocations(List<Location> locations);
    }
}
