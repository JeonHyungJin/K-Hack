package com.example.qpdjg.all_for.Adater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewpagerAdater extends FragmentPagerAdapter {
    int MAX_PAGE;
    public ViewpagerAdater(FragmentManager fm,int max) {
        super(fm);
        MAX_PAGE =max;
    }

    @Override
    public Fragment getItem(int position) {
        if (position < 0 || MAX_PAGE <= position)
            return null;
        return null;
    }

    @Override
    public int getCount() {
        return MAX_PAGE;
    }

}

