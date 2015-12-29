package com.aethernadev.storage.location;

/**
 * Created by Aetherna on 2015-12-29.
 */
public enum SettingType {
    DEFAULT(1), USER(2);

    private int type;

    SettingType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
