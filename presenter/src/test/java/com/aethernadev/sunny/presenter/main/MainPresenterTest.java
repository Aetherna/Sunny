package com.aethernadev.sunny.presenter.main;

import com.aethernadev.sunny.base.UseCaseExecutor;
import com.aethernadev.sunny.data.Location;
import com.aethernadev.sunny.presenter.main.MainPresenter;
import com.aethernadev.sunny.settings.GetUserSettingsUseCase;
import com.aethernadev.sunny.testutils.TestSyncUseCaseExecutor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainPresenterTest {

    MainPresenter testObject;
    @Mock
    GetUserSettingsUseCase getUserSettingsUseCase;
    @Mock
    MainPresenter.UI ui;

    UseCaseExecutor useCaseExecutor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        useCaseExecutor = new TestSyncUseCaseExecutor();

        testObject = new MainPresenter(getUserSettingsUseCase, useCaseExecutor);
        testObject.attachUI(ui);
    }

    @Test
    public void shouldShowWarningOnNoLocationsSelectedByUSer() throws Exception {

        //having
        List<Location> empty = new ArrayList<>();
        when(getUserSettingsUseCase.execute(null)).thenReturn(Observable.just(empty));

        //when
        testObject.loadUserSettings();

        //then
        verify(ui, times(1)).showEmptyLocationsWarning();

    }

    @Test
    public void shouldLaunchDisplayingForecastForLocations() throws Exception {

        //having
        List<Location> locations = new ArrayList<>();
        locations.add(Mockito.mock(Location.class));
        when(getUserSettingsUseCase.execute(null)).thenReturn(Observable.just(locations));

        //when
        testObject.loadUserSettings();

        //then
        verify(ui, times(1)).showLocationsForecast(locations);

    }


}