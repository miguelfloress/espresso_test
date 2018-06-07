package com.example.miguelflores.espressotest.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author nicolas.g
 * Receiver in charge of inform if there were changes in the type of network connection.
 */
public class NetworkBroadcastReceiver extends BroadcastReceiver {

    /**
     * Interface that is going to be use to notify any changes in the network connection.
     */
    public interface NetworkBroadcastListener {
        void onNetworkChangedEvent(NetworkChangedEvent networkChangedEvent);
    }

    private final NetworkBroadcastListener listener;

    public NetworkBroadcastReceiver(NetworkBroadcastListener listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connMgr = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkChangedEvent event = new NetworkChangedEvent(connMgr.getActiveNetworkInfo());
        listener.onNetworkChangedEvent(event);
    }

    /**
     * Class representing a network change event.
     */
    public static class NetworkChangedEvent {
        private final NetworkInfo networkInfo;

        private NetworkChangedEvent(NetworkInfo networkInfo) {
            this.networkInfo = networkInfo;
        }

        /**
         * Indicates whether network connectivity exists and it is possible to establish
         * connections and pass data.
         *
         * @return {@code true} if network connectivity exists, {@code false} otherwise.
         */
        public boolean hasConnection() {
            if (networkInfo != null) {
                return networkInfo.isConnected();
            }
            return false;
        }

        /**
         * Returns details about the currently active default data network.
         *
         * @return a {@link NetworkInfo} object for the current default network
         * or {@code null} if no network default network is currently active
         */
        public NetworkInfo getActiveNetworkInfo() {
            return networkInfo;
        }
    }
}
