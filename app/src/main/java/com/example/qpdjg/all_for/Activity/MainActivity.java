package com.example.qpdjg.all_for.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.qpdjg.all_for.Adater.ViewpagerAdapter;
import com.example.qpdjg.all_for.Custom.BottomTab;
import com.example.qpdjg.all_for.Custom.CustomViewPager;
import com.example.qpdjg.all_for.R;
import com.example.qpdjg.all_for.Util.GetViewPagerPage;
import com.example.qpdjg.all_for.Util.TitlebarActivity;

public class MainActivity extends TitlebarActivity {
    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    int MAX_PAGE=5;
    Fragment cur_fragment=new Fragment();
    ViewpagerAdapter viewpagerAdapter;
    GetViewPagerPage getViewPagerPage;
    CustomViewPager viewPager;
    BottomTab bottomTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=(CustomViewPager)findViewById(R.id.viewpager);
        viewPager.setSwipeEnabled(false);

        viewpagerAdapter =new ViewpagerAdapter(getSupportFragmentManager(),MAX_PAGE,viewPager);
        getViewPagerPage = new GetViewPagerPage();

        viewPager.setAdapter(viewpagerAdapter);
        viewPager.setViewpagerAdapter(viewpagerAdapter);
        viewPager.setOnPageChangeListener(getViewPagerPage);

        bottomTab = findViewById(R.id.menu_tab);
        bottomTab.setViewpager(viewPager);


    }
    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;
        if(getViewPagerPage.getCurrentPage() == 3) {
            bottomTab.setCatagory();
        }
        else if(getViewPagerPage.getCurrentPage() == 2) {
            bottomTab.setCatagory();
        }
        else if(getViewPagerPage.getCurrentPage() == 4) {
            viewPager.setCurrentItem(3);
        }
        else if(getViewPagerPage.getCurrentPage() == 1) {
            bottomTab.setHome();
        }

        else{
            if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime) {
                super.onBackPressed();
            } else {
                backPressedTime = tempTime;
                Toast.makeText(getApplicationContext(), R.string.double_press_end, Toast.LENGTH_SHORT).show();
            }
        }
    }

}