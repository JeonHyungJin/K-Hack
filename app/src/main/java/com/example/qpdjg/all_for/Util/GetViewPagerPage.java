package com.example.qpdjg.all_for.Util;

import android.support.v4.view.ViewPager;

public class GetViewPagerPage extends ViewPager.SimpleOnPageChangeListener {
    private int currentPage;
    public void onPageSelected(int position) {
        currentPage = position;
    }
    public final int getCurrentPage() {
        return currentPage;
    }
}
