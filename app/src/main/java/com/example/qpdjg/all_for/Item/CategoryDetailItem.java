package com.example.qpdjg.all_for.Item;


public class CategoryDetailItem {
    String appname;
    String subname;
    int rank;
    String icon;
    int download_rank;
    int korean_use_rank;

    public CategoryDetailItem(String appname, String subname, int rank, String icon) {
        this.appname = appname;
        this.subname = subname;
        this.rank = rank;
        this.icon = icon;
    }

    public CategoryDetailItem(String appname, String subname, int rank, String icon, int download_rank, int korean_use_rank) {
        this.appname = appname;
        this.subname = subname;
        this.rank = rank;
        this.icon = icon;
        this.download_rank = download_rank;
        this.korean_use_rank = korean_use_rank;
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

    public int getKorean_use_rank() { return korean_use_rank; }

    public int getDownload_rank() { return download_rank; }
}
