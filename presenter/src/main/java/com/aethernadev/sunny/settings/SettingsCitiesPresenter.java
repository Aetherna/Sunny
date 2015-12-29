package com.aethernadev.sunny.settings;

import com.aethernadev.sunny.FindLocationsUseCase;
import com.aethernadev.sunny.Location;
import com.aethernadev.sunny.base.BasePresenter;
import com.aethernadev.sunny.base.UIAction;
import com.aethernadev.sunny.base.UseCaseExecutor;
import com.aethernadev.sunny.usecaseexecutor.AsyncUseCaseExecutor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by Aetherna.
 */
public class SettingsCitiesPresenter extends BasePresenter<SettingsCitiesPresenter.SettingsUI> {

    private FindLocationsUseCase findLocationsUseCase;
    private UseCaseExecutor executor;
    private List<Location> selectedLocations = new ArrayList<>();

    @Inject
    public SettingsCitiesPresenter(FindLocationsUseCase findLocationsUseCase, AsyncUseCaseExecutor useCaseExecutor) {
        this.findLocationsUseCase = findLocationsUseCase;
        this.executor = useCaseExecutor;

    }

    public void onLocationSearch(final String location) {

        showLoading();

        executor.wrap(findLocationsUseCase, location).subscribe(new Observer<List<Location>>() {
            @Override
            public void onCompleted() {
                hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                ui.showError(e.getMessage());
            }

            @Override
            public void onNext(List<Location> locations) {
                if (locations.isEmpty()) {
                    showError("No location found!");
                }
                final Location locationToAdd = locations.get(0); //todo handle multiple
                selectedLocations.add(locationToAdd);

                execute(new UIAction<SettingsUI>() {
                    @Override
                    public void execute(SettingsUI settingsUI) {
                        ui.addLocation(locationToAdd);
                    }
                });
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

    public void loadSavedLocations() { //todo create use case
        Location stub1 = new Location();
        stub1.setName("Ala");
        stub1.setRegion("RegionAli");

        Location stub2 = new Location();
        stub2.setName("Beta2");
        stub2.setRegion("RegionBeta2");

        selectedLocations.add(stub1);
        selectedLocations.add(stub2);

        execute(new UIAction<SettingsUI>() {
            @Override
            public void execute(SettingsUI settingsUI) {
                ui.setLocations(selectedLocations);
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

    public interface SettingsUI {
        void addLocation(Location location);

        void setLocations(List<Location> locations);

        void showError(String error); //todo try use resource id from presenter layer:>

        void showLoading();

        void hideLoading();

        void hideError();
    }
}
