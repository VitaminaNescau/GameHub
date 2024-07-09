package com.launcher.gamehub;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import com.launcher.gamehub.component.CustomStatusBar;
import com.launcher.gamehub.tools.system.Battery;
import com.launcher.gamehub.tools.utils.General;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        General.getLog("Init App");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        hideStatusBar();
      //  new CustomStatusBar().run();
        View customStatusBar = findViewById(R.id.customStatusBar);

    }

    private void hideStatusBar() {
        WindowInsetsControllerCompat windowInsetsControllerCompat = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());

        windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.statusBars()|WindowInsetsCompat.Type.navigationBars());

    }
}