package com.aethernadev.storage;

import android.test.AndroidTestCase;

import com.aethernadev.storage.location.RealmLocation;
import com.aethernadev.storage.location.RealmLocationMapper;
import com.aethernadev.sunny.data.Location;

import junit.framework.Assert;

import io.realm.Realm;

/**
 * Created by Aetherna.
 */
public class RealmLocationMapperTest extends AndroidTestCase {

    RealmLocationMapper objectUnderTest;
    Realm realm;

    public void setUp() throws Exception {
        objectUnderTest = new RealmLocationMapper();
        realm = Realm.getInstance(getContext());
    }

    public void testShouldThrowOnNulls() {

        //when
        try {
            objectUnderTest.mapToRealm(null, null);
            Assert.fail();
        } catch (RuntimeException ex) {
            //success
        }
    }

    public void testShouldThrowOnNullLocation() {

        //having
        realm.beginTransaction();
        RealmLocation realmLocation = realm.createObject(RealmLocation.class);
        //when
        try {
            objectUnderTest.mapToRealm(null, realmLocation);
            Assert.fail();
        } catch (RuntimeException ex) {
            //success
            realm.cancelTransaction();
        }
        //then
    }

    public void testShouldThrowOnNullRealmLocation() {

        //having
        Location location = new Location();

        //when
        try {
            objectUnderTest.mapToRealm(location, null);
            Assert.fail();
        } catch (RuntimeException ex) {
            //success
        }
    }

    public void testShouldMapProperly() {
        //having
        String testName = "TestName";
        String testRegion = "TestRegion";
        String testCountry = "TestCountry";
        double testLatitude = 1254.12;
        double testLongitude = 12345.67;

        Location sourceLocation = new Location();
        sourceLocation.setName(testName);
        sourceLocation.setRegion(testRegion);
        sourceLocation.setCountry(testCountry);
        sourceLocation.setLatitude(testLatitude);
        sourceLocation.setLongitude(testLongitude);

        realm.beginTransaction();
        RealmLocation target = realm.createObject(RealmLocation.class);

        //when
        objectUnderTest.mapToRealm(sourceLocation, target);

        //then

        Assert.assertEquals(target.getName(), testName);
        Assert.assertEquals(target.getRegion(), testRegion);
        Assert.assertEquals(target.getCountry(), testCountry);
        Assert.assertEquals(target.getLatitude(), testLatitude);
        Assert.assertEquals(target.getLongitude(), testLongitude);

        realm.cancelTransaction();

    }

    public void testShouldMapNullsToEmptyString() {
        //having

        Location sourceLocation = new Location();
        sourceLocation.setName(null);

        realm.beginTransaction();
        RealmLocation target = realm.createObject(RealmLocation.class);

        //when
        objectUnderTest.mapToRealm(sourceLocation, target);

        //then
        Assert.assertEquals(target.getName(), "");
        realm.cancelTransaction();
    }

    public void testShouldMapSpaceEmptyToEmptyString() {
        //having

        Location sourceLocation = new Location();
        sourceLocation.setName("   ");

        realm.beginTransaction();
        RealmLocation target = realm.createObject(RealmLocation.class);

        //when
        objectUnderTest.mapToRealm(sourceLocation, target);

        //then
        Assert.assertEquals(target.getName(), "");
        realm.cancelTransaction();
    }


    public void testShouldThrowOnNullRealmLocationOnMapToLocation() {

        //when
        try {
            objectUnderTest.mapToLocation(null);
            Assert.fail();
        } catch (RuntimeException ex) {
            //success
        }
    }

    public void testShouldProperlyMapToLocation() {
        //having

        String testName = "TestName";
        String testRegion = "TestRegion";
        String testCountry = "TestCountry";
        double testLatitude = 1254.12;
        double testLongitude = 12345.67;

        realm.beginTransaction();
        RealmLocation source = realm.createObject(RealmLocation.class);
        source.setName(testName);
        source.setRegion(testRegion);
        source.setCountry(testCountry);
        source.setLatitude(testLatitude);
        source.setLongitude(testLongitude);

        //when
        Location target = objectUnderTest.mapToLocation(source);

        //then
        Assert.assertEquals(target.getName(), testName);
        Assert.assertEquals(target.getRegion(), testRegion);
        Assert.assertEquals(target.getCountry(), testCountry);
        Assert.assertEquals(target.getLatitude(), testLatitude);
        Assert.assertEquals(target.getLongitude(), testLongitude);
        realm.cancelTransaction();
    }

}
