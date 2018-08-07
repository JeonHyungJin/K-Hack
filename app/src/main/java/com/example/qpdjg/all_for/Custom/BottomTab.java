package com.example.qpdjg.all_for.Custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qpdjg.all_for.R;

public class BottomTab  extends LinearLayout {
    LinearLayout home;
    LinearLayout catagory;
    LinearLayout mypage;

    ImageView homeImg;
    ImageView catagoryImg;
    ImageView mypageImg;

    TextView homeTxt;
    TextView catagoryTxt;
    TextView mypageTxt;

    public BottomTab(Context context) {
        super(context);
        initView();
    }
    public BottomTab(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();

    }
    public BottomTab(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        initView();

    }
    private void initView() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        View v = li.inflate(R.layout.bar_menu, this, false);
        addView(v);

        home = (LinearLayout)findViewById(R.id.menu_home);
        catagory = (LinearLayout)findViewById(R.id.menu_catagory);
        mypage = (LinearLayout)findViewById(R.id.menu_mypage);

        homeImg = (ImageView)findViewById(R.id.menu_homeImg);
        catagoryImg = (ImageView)findViewById(R.id.menu_catagoryImg);
        mypageImg = (ImageView)findViewById(R.id.menu_mypageImg);

        homeTxt = (TextView)findViewById(R.id.menu_homeTxt);
        catagoryTxt = (TextView)findViewById(R.id.menu_catagoryTxt);
        mypageTxt = (TextView)findViewById(R.id.menu_mypageTxt);

    }



}