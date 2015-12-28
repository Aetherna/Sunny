package com.aethernadev.sunny.settings;

import com.aethernadev.sunny.FindLocationsUseCase;
import com.aethernadev.sunny.Location;
import com.aethernadev.sunny.base.BasePresenter;
import com.aethernadev.sunny.base.UseCaseExecutor;
import com.aethernadev.sunny.usecaseexecutor.AsyncUseCaseExecutor;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

/**
 * Created by Aetherna on 2015-12-27.
 */
public class SettingsPresenter extends BasePresenter<SettingsPresenter.SettingsUI> {

    private FindLocationsUseCase findLocationsUseCase;
    private UseCaseExecutor executor;

    @Inject
    public SettingsPresenter(FindLocationsUseCase findLocationsUseCase, AsyncUseCaseExecutor useCaseExecutor) {
        this.findLocationsUseCase = findLocationsUseCase;
        this.executor = useCaseExecutor;
    }

    public void onLocationSearch(final String location) {
        executor.wrap(findLocationsUseCase, location).subscribe(new Observer<List<Location>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                ui.showError(e.getMessage());
            }

            @Override
            public void onNext(List<Location> locations) {
                ui.addLocation(locations.get(0));
            }
        });

    }

    public interface SettingsUI {
        void addLocation(Location location);

        void showError(String error); //todo try use resource id from presenter layer:>
    }
}
