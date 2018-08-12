package com.example.qpdjg.all_for.Custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.qpdjg.all_for.R;

public class ImageViewer extends LinearLayout {
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
    }
}
