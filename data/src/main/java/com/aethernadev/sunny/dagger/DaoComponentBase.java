package com.aethernadev.sunny.dagger;

import com.aethernadev.sunny.dao.SettingsDao;
import com.aethernadev.sunny.dao.WeatherDao;

/**
 * Created by Aetherna on 2015-12-28.
 */
public interface DaoComponentBase {

    WeatherDao weatherDao();

    SettingsDao settingsDao();

}
