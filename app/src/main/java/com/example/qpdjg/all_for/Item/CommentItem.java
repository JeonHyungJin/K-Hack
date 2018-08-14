package com.example.qpdjg.all_for.Item;

public class CommentItem {
    String rank;
    String date;
    String name;
    String contents;

    public CommentItem(String rank, String date, String name, String text) {
        this.rank = rank;
        this.date = date;
        this.name = name;
        this.contents = text;
    }

    public int getRank() {
        return Integer.parseInt(rank);
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return contents;
    }
}
