package com.launcher.gamehub.tools.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

public class  Battery extends BroadcastReceiver {
    private BatteryStatusListener listener;
    public Battery(BatteryStatusListener listener){
        this.listener = listener;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
        boolean isCharging =  status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;
        float batteryPct = level * 100 / (float)scale;
        listener.onBatteryStatusChanged(batteryPct,isCharging);
    }
    public interface BatteryStatusListener {
        void onBatteryStatusChanged(float batteryPct, boolean isCharging);
    }
}