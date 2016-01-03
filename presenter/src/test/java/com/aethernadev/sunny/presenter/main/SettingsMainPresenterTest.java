package com.aethernadev.sunny.presenter.main;

import com.aethernadev.sunny.base.UseCaseExecutor;
import com.aethernadev.sunny.data.Location;
import com.aethernadev.sunny.presenter.settings.SettingsMainPresenter;
import com.aethernadev.sunny.settings.SaveUserSettingsUseCase;
import com.aethernadev.sunny.testutils.TestSyncUseCaseExecutor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Marta on 03/01/2016.
 */
public class SettingsMainPresenterTest {
    SettingsMainPresenter testObject;
    @Mock
    SaveUserSettingsUseCase saveUserSettingsUseCase;
    @Mock
    SettingsMainPresenter.UI ui;

    UseCaseExecutor useCaseExecutor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        useCaseExecutor = new TestSyncUseCaseExecutor();

        testObject = new SettingsMainPresenter(saveUserSettingsUseCase, useCaseExecutor);
        testObject.attachUI(ui);
    }

    @Test
    public void shouldCloseSettingsOnSave() {
        //having
        List<Location> locations = new ArrayList<>();
        when(saveUserSettingsUseCase.execute(locations)).thenReturn(Observable.just(Boolean.TRUE));

        //when
        testObject.saveSettings(locations);

        //then
        verify(ui, times(1)).closeSettings();
    }

    @Test
    public void shouldWhatCloseSettingsOnSave() {
        //having
        List<Location> locations = null;
        when(saveUserSettingsUseCase.execute(locations)).thenReturn(Observable.just(Boolean.TRUE));

        //when
        testObject.saveSettings(locations);

        //then
        verify(ui, times(1)).closeSettings();
    }
}
