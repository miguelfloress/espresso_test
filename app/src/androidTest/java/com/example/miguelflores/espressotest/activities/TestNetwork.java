package com.example.miguelflores.espressotest.activities;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.miguelflores.espressotest.broadcastreceiver.NetworkBroadcastReceiver;
import com.example.miguelflores.espressotest.util.NetworkUtil;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author nicolas.g
 */
@RunWith(AndroidJUnit4.class)
public class TestNetwork {

    private static String connectionState;

    @Test
    public void testNetworkState() throws Throwable {
        final Context applicationContext = InstrumentationRegistry.getTargetContext().getApplicationContext();
        final Object objectWait = new Object();
        TestNetworkBroadcastListener testNetworkBroadcastListener = new TestNetworkBroadcastListener(objectWait);
        NetworkBroadcastReceiver networkBroadcastReceiver = new NetworkBroadcastReceiver(testNetworkBroadcastListener);

        applicationContext.registerReceiver(networkBroadcastReceiver,
                new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

        NetworkUtil.disableNetworkConnection();
        synchronized (networkBroadcastReceiver) {
            networkBroadcastReceiver.wait(2000);
        }

        Assert.assertEquals("false", connectionState);

        NetworkUtil.enableNetworkConnection();
        synchronized (networkBroadcastReceiver) {
            networkBroadcastReceiver.wait(2000);
        }

        Assert.assertEquals("true", connectionState);

        applicationContext.unregisterReceiver(networkBroadcastReceiver);
    }

    private static class TestNetworkBroadcastListener implements NetworkBroadcastReceiver.NetworkBroadcastListener {

        private final NetworkBroadcastReceiver networkBroadcastReceiver;
        private final Object lockObject;

        public TestNetworkBroadcastListener(Object lockObject) {
            this.lockObject = lockObject;
            networkBroadcastReceiver = new NetworkBroadcastReceiver(this);
        }

        @Override
        public void onNetworkChangedEvent(NetworkBroadcastReceiver.NetworkChangedEvent networkChangedEvent) {
            connectionState = String.valueOf(networkChangedEvent.hasConnection());
            synchronized (lockObject) {
                lockObject.notify();
            }
        }
    }
}