package com.example.qpdjg.all_for.Item;

public class CommentItem {
    int rank;
    String date;
    String name;
    String text;

    public CommentItem(int rank, String date, String name, String text) {
        this.rank = rank;
        this.date = date;
        this.name = name;
        this.text = text;
    }

    public int getRank() {
        return rank;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
