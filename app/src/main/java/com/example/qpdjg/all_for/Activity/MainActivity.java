package com.example.qpdjg.all_for.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.qpdjg.all_for.Adater.ViewpagerAdapter;
import com.example.qpdjg.all_for.Custom.BottomTab;
import com.example.qpdjg.all_for.Custom.CustomViewPager;
import com.example.qpdjg.all_for.R;
import com.example.qpdjg.all_for.Util.TitlebarActivity;

public class MainActivity extends TitlebarActivity {

    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;
    int MAX_PAGE=3;
    Fragment cur_fragment=new Fragment();
    ViewpagerAdapter viewpagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomViewPager viewPager=(CustomViewPager)findViewById(R.id.viewpager);
        viewPager.setSwipeEnabled(false);

        viewpagerAdapter =new ViewpagerAdapter(getSupportFragmentManager(),4,viewPager);

        viewPager.setAdapter(viewpagerAdapter);
        viewPager.setViewpagerAdapter(viewpagerAdapter);

        BottomTab bottomTab = findViewById(R.id.menu_tab);
        bottomTab.setViewpager(viewPager);


    }
    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime)
        {
            super.onBackPressed();
        }
        else
        {
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(), R.string.double_press_end, Toast.LENGTH_SHORT).show();
        }
    }
}