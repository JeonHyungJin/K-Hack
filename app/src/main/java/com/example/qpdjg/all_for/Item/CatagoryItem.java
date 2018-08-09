package com.example.qpdjg.all_for.Item;

import android.content.Intent;
import android.graphics.drawable.Drawable;

public class CatagoryItem {
    Drawable icon;
    String txt;
    String toCall;

    public CatagoryItem(Drawable icon, String txt, String toCall) {
        this.icon = icon;
        this.txt = txt;
        this.toCall = toCall;
    }

    public Drawable getIcon() {
        return icon;
    }

    public String gettoCall() {
        return toCall;
    }

    public String getTxt() {
        return txt;
    }
}
