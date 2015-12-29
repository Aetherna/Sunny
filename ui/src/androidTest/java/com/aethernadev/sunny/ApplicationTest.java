package com.aethernadev.sunny;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<SunnyApp> {
    public ApplicationTest() {
        super(SunnyApp.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

    }

    public void testShouldReturnAppComponent() {
        //when
        createApplication();
        //then
        assertNotNull(getApplication().getAppComponent());
    }

}