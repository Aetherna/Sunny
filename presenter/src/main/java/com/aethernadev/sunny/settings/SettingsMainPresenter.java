package com.aethernadev.sunny.settings;

import com.aethernadev.sunny.data.Location;
import com.aethernadev.sunny.base.BasePresenter;
import com.aethernadev.sunny.base.UIAction;
import com.aethernadev.sunny.base.UseCaseExecutor;

import java.util.List;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by Aetherna on 2015-12-29.
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
