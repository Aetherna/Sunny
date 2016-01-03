package com.aethernadev.sunny.dagger;

import com.aethernadev.sunny.dao.SettingsDao;
import com.aethernadev.sunny.dao.WeatherDao;

/**
 * Created by Aetherna.
 */
public interface DaoComponentBase {

    WeatherDao weatherDao();

    SettingsDao settingsDao();

}
