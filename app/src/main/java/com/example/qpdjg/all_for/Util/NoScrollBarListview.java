package com.example.qpdjg.all_for.Util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class NoScrollBarListview extends ListView {
    public NoScrollBarListview(Context context) {
        super(context);
    }

    public NoScrollBarListview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollBarListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        //return super.onTouchEvent(ev);
        return false;
    }
}
