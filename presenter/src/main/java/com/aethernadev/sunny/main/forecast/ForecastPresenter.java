package com.aethernadev.sunny.main.forecast;

import com.aethernadev.sunny.base.BasePresenter;
import com.aethernadev.sunny.base.UIAction;
import com.aethernadev.sunny.base.UseCaseExecutor;
import com.aethernadev.sunny.data.Forecast;
import com.aethernadev.sunny.data.Location;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class ForecastPresenter extends BasePresenter<ForecastPresenter.UI> {

    GetForecastUseCase getForecastUseCase;
    UseCaseExecutor executor;

    @Inject
    public ForecastPresenter(GetForecastUseCase getForecastUseCase, UseCaseExecutor executor) {
        this.getForecastUseCase = getForecastUseCase;
        this.executor = executor;
    }

    public void loadForecast(Location location) {

        showLoading();

        executor.wrap(getForecastUseCase, location).subscribe(new Observer<Forecast>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                showError(e.getMessage()); //todo
            }

            @Override
            public void onNext(Forecast forecast) {
                showForecast(forecast);
            }
        });


    }

    private void showError(final String message) {
        execute(new UIAction<UI>() {
            @Override
            public void execute(UI ui) {
                ui.showError(message);
            }
        });
    }

    private void showLoading() {
        execute(new UIAction<UI>() {
            @Override
            public void execute(UI ui) {
                ui.showLoading();
            }
        });
    }

    private void showForecast(final Forecast forecast) {
        execute(new UIAction<UI>() {
            @Override
            public void execute(UI ui) {
                ui.showForecast(forecast);
            }
        });
    }

    public interface UI {
        void showLoading();

        void showForecast(Forecast forecast);

        void showError(String error);
    }
}
