package com.example.miguelflores.espressotest.util;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;

import java.io.IOException;

/**
 * Utils for network connection
 *
 * @author nicolas.g
 */
public class NetworkUtil {

    /**
     * Enable the network connection.
     */
    public static void enableNetworkConnection() throws IOException {
        getUiDevice().executeShellCommand("svc wifi enable");
        getUiDevice().executeShellCommand("svc data enable");
    }

    /**
     * Disable the network connection.
     */
    public static void disableNetworkConnection() throws IOException {
        getUiDevice().executeShellCommand("svc wifi disable");
        getUiDevice().executeShellCommand("svc data disable");
    }

    /**
     * This method get an instance of the UiDevice
     *
     * @return the instance of the UiDevice
     */
    private static UiDevice getUiDevice() {
        return UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }
}