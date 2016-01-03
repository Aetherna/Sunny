package com.aethernadev.sunny.presenter.main.forecast;

import com.aethernadev.sunny.presenter.base.BasePresenter;
import com.aethernadev.sunny.presenter.base.UIAction;
import com.aethernadev.sunny.base.UseCaseExecutor;
import com.aethernadev.sunny.data.Forecast;
import com.aethernadev.sunny.data.Location;
import com.aethernadev.sunny.presenter.error.PrintableError;
import com.aethernadev.sunny.presenter.error.SunnyError;
import com.aethernadev.sunny.presenter.error.UnknownError;
import com.aethernadev.sunny.main.forecast.GetForecastUseCase;

import java.net.UnknownHostException;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by Aetherna.
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
                if (e instanceof UnknownHostException) {
                    showError(SunnyError.CONNECTION_ERROR);
                } else {
                    showError(new UnknownError(e));
                }
            }

            @Override
            public void onNext(Forecast forecast) {
                showForecast(forecast);
            }
        });


    }

    private void showError(final PrintableError message) {
        execute(new UIAction<UI>() {
            @Override
            public void execute(UI ui) {
                ui.hideLoading();
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

        void showError(PrintableError error);

        void hideLoading();
    }
}
