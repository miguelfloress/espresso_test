package com.example.miguelflores.espressotest.util;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

/**
 * Created by miguel.flores.
 */
public class MyUtilValidator {

    public static String getResourceString(int id, String... params) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        return targetContext.getResources().getString(id, params);
    }
}
