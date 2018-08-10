package com.example.qpdjg.all_for.Item;



public class CategoryDetailItem {
    String appname;
    String subname;
    float rank;
    String icon;

    public CategoryDetailItem(String appname, String subname, float rank, String icon) {
        this.appname = appname;
        this.subname = subname;
        this.rank = rank;
        this.icon = icon;
    }

    public String getAppname() {
        return appname;
    }

    public String getSubname() {
        return subname;
    }

    public float getRank() {
        return rank;
    }

    public String getIcon() {
        return icon;
    }
}
