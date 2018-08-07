package com.example.qpdjg.all_for.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.qpdjg.all_for.R;

public class SplashActivity  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // getSupportActionBar().hide();
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                finish();    // 액티비티 종료
            }
        };
        handler.sendEmptyMessageDelayed(0, 1500);
    }

}