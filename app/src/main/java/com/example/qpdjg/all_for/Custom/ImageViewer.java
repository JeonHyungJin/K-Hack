package com.example.qpdjg.all_for.Custom;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.qpdjg.all_for.Activity.ImageActivity;
import com.example.qpdjg.all_for.R;

import java.util.ArrayList;

public class ImageViewer extends LinearLayout {

    ArrayList <String> url = new ArrayList<String>();
    ImageView viewer;
    int now;
    public ImageViewer(Context context) {
        super(context);
        initView();

    }

    public ImageViewer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();

    }

    public ImageViewer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();

    }

    private void initView() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        View v = li.inflate(R.layout.custom_image_viewer, this, false);
        addView(v);

        LinearLayout prev = (LinearLayout)findViewById(R.id.imageViewer_prev);
        LinearLayout next  = (LinearLayout)findViewById(R.id.imageViewer_next);
        viewer = (ImageView)findViewById(R.id.imageViewer_imageview);

        prev.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                prevImage();
            }
        });
        next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                nextImage();
            }
        });
        viewer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(new Intent(getContext(), ImageActivity.class).putExtra("url",url.get(now)));
            }
        });

    }

    public void setUrl(ArrayList<String> url) {
        this.url = url;
        now = 0;
        Glide.with(getContext()).load(url.get(now)).into(viewer);
    }

    private void nextImage(){
        if(!(now +1>= url.size())){
            Glide.with(getContext()).load(url.get(++now)).into(viewer);
        }
    }

    private void prevImage(){
        if(!(now == 0 )){
            Glide.with(getContext()).load(url.get(--now)).into(viewer);
        }
    }
}
