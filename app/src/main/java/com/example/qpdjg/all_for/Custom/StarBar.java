package com.example.qpdjg.all_for.Custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.qpdjg.all_for.R;

public class StarBar extends LinearLayout {
    int starCount;
    ImageView star[] = new ImageView[5];

    public StarBar(Context context) {
        super(context);
        initView();
    }

    public StarBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public StarBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }
    private void initView() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        View v = li.inflate(R.layout.custom_starbar, this, false);
        addView(v);

        star[0] = (ImageView)findViewById(R.id.starbar_item_star1);
        star[1] = (ImageView)findViewById(R.id.starbar_item_star2);
        star[2] = (ImageView)findViewById(R.id.starbar_item_star3);
        star[3] = (ImageView)findViewById(R.id.starbar_item_star4);
        star[4] = (ImageView)findViewById(R.id.starbar_item_star5);

        star[0].setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setStar(1);
            }
        });
        star[1].setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setStar(2);
            }
        });
        star[2].setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setStar(3);
            }
        });
        star[3].setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setStar(4);
            }
        });
        star[4].setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setStar(5);
            }
        });
    }

    private void setStar(int count){
        for(int i =0; i< count; ++i){
            star[i].setBackground(ContextCompat.getDrawable(getContext(),R.drawable.star_full));

        }
        for(int i = count; i< 5; ++i){
            star[i].setBackground(ContextCompat.getDrawable(getContext(),R.drawable.blank));
        }
        starCount = count;
    }

    public int getStar() {
        return starCount;
    }
}
