package com.aethernadev.sunny.presenter.settings;

import com.aethernadev.sunny.data.Location;
import com.aethernadev.sunny.presenter.base.BasePresenter;
import com.aethernadev.sunny.presenter.base.UIAction;
import com.aethernadev.sunny.base.UseCaseExecutor;
import com.aethernadev.sunny.settings.SaveUserSettingsUseCase;

import java.util.List;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by Aetherna.
 */
public class SettingsMainPresenter extends BasePresenter<SettingsMainPresenter.UI> {

    private SaveUserSettingsUseCase saveUserSettings;
    private UseCaseExecutor executor;

    @Inject
    public SettingsMainPresenter(SaveUserSettingsUseCase saveUserSettings, UseCaseExecutor executor) {
        this.saveUserSettings = saveUserSettings;
        this.executor = executor;
    }

    public void saveSettings(List<Location> locations) {
        executor.wrap(saveUserSettings, locations).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                closeSettingsScreen();
            }
        });
    }

    private void closeSettingsScreen() {
        execute(new UIAction<UI>() {
            @Override
            public void execute(UI ui) {
                ui.closeSettings();
            }
        });
    }

    public interface UI {
        void closeSettings();
    }
}
