package com.aethernadev.storage;

import com.aethernadev.storage.location.RealmLocationMapper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.realm.Realm;

/**
 * Created by Marta on 03/01/2016.
 */
public class SettingsDaoImplTest {

    SettingsDaoImpl testObject;
    @Mock
    RealmLocationMapper realmLocationMapper;
    @Mock
    Realm realm;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        testObject = new SettingsDaoImpl(realmLocationMapper, realm);

    }

    @Test
    public void testSaveUserLocations() throws Exception {
        //todo
    }

    @Test
    public void testGetUserLocations() throws Exception {

    }
}