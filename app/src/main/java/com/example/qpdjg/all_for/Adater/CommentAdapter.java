package com.example.qpdjg.all_for.Adater;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qpdjg.all_for.Custom.CustomViewPager;
import com.example.qpdjg.all_for.Item.CategoryItem;
import com.example.qpdjg.all_for.Item.CommentItem;
import com.example.qpdjg.all_for.R;

import java.util.ArrayList;

public class CommentAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<CommentItem> data;
    private int layout;
    Context context;


    public CommentAdapter(Context context, int layout, ArrayList<CommentItem> data){
        this.context = context;
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data=data;
        this.layout=layout;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if(convertView==null) {
            convertView = inflater.inflate(layout, viewGroup, false);
        }
        ImageView star[] = new ImageView[5];
        star[0] = (ImageView)convertView.findViewById(R.id.comment_item_star1);
        star[1] = (ImageView)convertView.findViewById(R.id.comment_item_star2);
        star[2] = (ImageView)convertView.findViewById(R.id.comment_item_star3);
        star[3] = (ImageView)convertView.findViewById(R.id.comment_item_star4);
        star[4] = (ImageView)convertView.findViewById(R.id.comment_item_star5);

        TextView name = (TextView)convertView.findViewById(R.id.comment_name);
        TextView date = (TextView)convertView.findViewById(R.id.comment_date);
        TextView comment = (TextView)convertView.findViewById(R.id.comment_comment);


        name.setText(data.get(i).getName());
        date.setText(data.get(i).getDate());
        comment.setText(data.get(i).getText());


        for(int j =0; i< data.get(i).getRank(); ++j){
            star[j].setBackground(ContextCompat.getDrawable(context,R.drawable.star_full));
        }


        return convertView;
    }

    public void setData(ArrayList<CommentItem> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
