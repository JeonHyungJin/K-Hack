package com.example.qpdjg.all_for.Custom;

import android.content.Context;
import android.support.v4.content.ContextCompat;
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

        home.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                activeHome();
                offCatagory();
                offMypage();
                homePressed();
            }
        });

        catagory.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                offHome();
                activeCatagory();
                offMypage();
                catgoryPressed();
            }
        });

        mypage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                offHome();
                offCatagory();
                activeMypage();
                mypagePressed();
            }
        });
    }

    private void activeHome(){
        homeImg.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.home_color));
        homeTxt.setTextColor(ContextCompat.getColor(getContext(),R.color.light_blue));
    }
    private void offHome(){
        homeImg.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.home_gray));
        homeTxt.setTextColor(ContextCompat.getColor(getContext(),R.color.dark));
    }

    private void activeCatagory(){
        catagoryImg.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.category_color));
        catagoryTxt.setTextColor(ContextCompat.getColor(getContext(),R.color.light_blue));
    }
    private void offCatagory(){
        homeImg.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.category_color));
        homeTxt.setTextColor(ContextCompat.getColor(getContext(),R.color.dark));
    }

    private void activeMypage(){
        mypageImg.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.mypage_color));
        mypageTxt.setTextColor(ContextCompat.getColor(getContext(),R.color.light_blue));
    }
    private void offMypage(){
        mypageImg.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.mypage_gray));
        mypageTxt.setTextColor(ContextCompat.getColor(getContext(),R.color.dark));
    }

    public void homePressed(){}
    public void catgoryPressed(){}
    public void mypagePressed(){}

}