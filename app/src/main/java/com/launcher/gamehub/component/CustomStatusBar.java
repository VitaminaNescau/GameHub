package com.launcher.gamehub.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.launcher.gamehub.R;
import com.launcher.gamehub.tools.system.Battery;
import com.launcher.gamehub.tools.system.Network;
import com.launcher.gamehub.tools.utils.General;

public class CustomStatusBar extends RelativeLayout implements Battery.BatteryStatusListener {

    private TextView batteryTextView;
    private TextView wifiView;

    private Battery batteryReceiver;
    private Context context;

    public CustomStatusBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomStatusBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        RelativeLayout.inflate(context,R.layout.custom_status_bar,this);
        batteryTextView = findViewById(R.id.batteryTextView);
        wifiView = findViewById(R.id.wifiStatus);
        //handler = new Handler(Looper.getMainLooper());
        batteryReceiver = new Battery(this);

        // Registra o receiver da bateria
        IntentFilter batteryFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        context.registerReceiver(batteryReceiver, batteryFilter);
       // IntentFilter wifiFilter = new IntentFilter(Intent.)
        // Inicia a verificação periódica
        //handler.post(this);
    }



    @Override
    public void onBatteryStatusChanged(float batteryPct, boolean isCharging) {
        String status = "Battery level: " + batteryPct + "%";
        if (isCharging) {
            status += " (Charging)";
        }
        batteryTextView.setText(status);
    }



}
