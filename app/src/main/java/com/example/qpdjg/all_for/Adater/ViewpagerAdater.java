package com.example.qpdjg.all_for.Adater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.qpdjg.all_for.Fragment.CatagoryFragment;
import com.example.qpdjg.all_for.Fragment.MainFragment;
import com.example.qpdjg.all_for.Fragment.MypageFragment;

public class ViewpagerAdater extends FragmentPagerAdapter {
    int MAX_PAGE;
    Fragment cur_fragment=new Fragment();
    MainFragment mainFragment = new MainFragment();
    CatagoryFragment catagoryFragment = new CatagoryFragment();
    MypageFragment mypageFragment = new MypageFragment();
    public ViewpagerAdater(FragmentManager fm,int max) {
        super(fm);
        MAX_PAGE =max;
    }

    @Override
    public Fragment getItem(int position) {
        if (position < 0 || MAX_PAGE <= position)
            return null;
        switch (position){
            case 0:
                cur_fragment=mainFragment;
                break;
            case 1:
                cur_fragment=catagoryFragment;
                break;
            case 2:
                cur_fragment=mypageFragment;
                break;
        }
        return cur_fragment;
    }

    @Override
    public int getCount() {
        return MAX_PAGE;
    }

}

