package com.example.miguelflores.espressotest.util;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.DataInteraction;

import static android.support.test.espresso.Espresso.onData;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by miguel.flores.
 */
public class MyUtilValidator {

    public static String getResourceString(int id, String... params) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        return targetContext.getResources().getString(id, params);
    }

    /**
     * @param mClass class of the items in the adapterList
     * @param object object to find in the adapter itemList
     *
     * @return
     */
    public static DataInteraction getDataInteraction(Class mClass, Object object) {
        return onData(allOf(is(instanceOf(mClass)), is(object)));
    }
}
