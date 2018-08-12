package com.example.qpdjg.all_for.Item;



public class CategoryDetailItem {
    String appname;
    String subname;
    int rank;
    String icon;

    public CategoryDetailItem(String appname, String subname, int rank, String icon) {
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

    public int getRank() {
        return rank;
    }

    public String getIcon() {
        return icon;
    }
}
