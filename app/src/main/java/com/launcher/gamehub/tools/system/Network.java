package com.launcher.gamehub.tools.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

public class Network {
    public interface NetworkListener{
        void networkStatus(boolean isConnect);

    }

}