package com.example.qpdjg.all_for.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.qpdjg.all_for.Adater.ViewpagerAdapter;
import com.example.qpdjg.all_for.Custom.BottomTab;
import com.example.qpdjg.all_for.Custom.CustomViewPager;
import com.example.qpdjg.all_for.R;
import com.example.qpdjg.all_for.Util.TitlebarActivity;

public class MainActivity extends TitlebarActivity {
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
}