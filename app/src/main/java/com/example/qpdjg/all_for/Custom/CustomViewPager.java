package com.example.qpdjg.all_for.Custom;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.qpdjg.all_for.Adater.ViewpagerAdapter;

public class CustomViewPager extends ViewPager {
    private boolean swipeEnabled;
    private ViewpagerAdapter viewpagerAdapter;
    public CustomViewPager(Context context) {
        super(context);
        swipeEnabled = true;
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        swipeEnabled = true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(this.swipeEnabled){
            return super.onTouchEvent(ev);
        }
        return false;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.swipeEnabled) {
            return super.onInterceptTouchEvent(event);
        }

        return false;
    }

    public void setViewpagerAdapter(ViewpagerAdapter viewpagerAdapter) {
        this.viewpagerAdapter = viewpagerAdapter;
    }

    public ViewpagerAdapter getViewpagerAdapter() {
        return viewpagerAdapter;
    }

    public void setSwipeEnabled(boolean enabled) {
        this.swipeEnabled = enabled;
    }
}


