package com.example.qpdjg.all_for.Adater;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.qpdjg.all_for.Custom.CustomViewPager;
import com.example.qpdjg.all_for.Fragment.CategoryDetailFragment;
import com.example.qpdjg.all_for.Fragment.CategoryFragment;
import com.example.qpdjg.all_for.Fragment.MainFragment;
import com.example.qpdjg.all_for.Fragment.MypageFragment;
import com.example.qpdjg.all_for.Fragment.ViewAppFragment;

public class ViewpagerAdapter extends FragmentPagerAdapter {
    int MAX_PAGE;
    Fragment cur_fragment=new Fragment();
    MainFragment mainFragment = new MainFragment();
    CategoryFragment categoryFragment = new CategoryFragment();
    MypageFragment mypageFragment = new MypageFragment();
    CategoryDetailFragment categoryDetailFragment = new CategoryDetailFragment();
    ViewAppFragment viewAppFragment = new ViewAppFragment();
    ViewPager viewPager;

    private boolean swipeEnabled;

    public ViewpagerAdapter(FragmentManager fm, int max, CustomViewPager viewPager, Context context) {
        super(fm);
        MAX_PAGE =max;
        this.viewPager = viewPager;
        categoryFragment.setViewPager(viewPager);
        categoryDetailFragment.setViewPager(viewPager);
        categoryDetailFragment.dataRefresh(context);
        mypageFragment.refreshData();
    }

    @Override
    public Fragment getItem(int position) {
        if (position < 0 || MAX_PAGE <= position )
            return null;
        switch (position){
            case 0:
                cur_fragment=mainFragment;
                break;
            case 1:
                cur_fragment=categoryFragment;
                break;
            case 2:
                cur_fragment=mypageFragment;
                break;
            case 3:
                cur_fragment=categoryDetailFragment;
                break;
            case 4:
                cur_fragment=viewAppFragment;
                break;

        }
        return cur_fragment;
    }


    @Override
    public int getCount() {
        return MAX_PAGE;
    }

    public void setToCall(String toCall){
        categoryDetailFragment.setToCall(toCall);
    }
    public void  setAppCall(String appCall,String category){
        viewAppFragment.setAppCall(appCall,category);}

}


