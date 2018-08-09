package com.example.qpdjg.all_for.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.qpdjg.all_for.Adater.ViewpagerAdater;
import com.example.qpdjg.all_for.R;
import com.example.qpdjg.all_for.Util.TitlebarActivity;

public class MainActivity extends TitlebarActivity {
    int MAX_PAGE=3;
    Fragment cur_fragment=new Fragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(new ViewpagerAdater(getSupportFragmentManager(),3));
    }
}