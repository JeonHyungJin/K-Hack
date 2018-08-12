package com.example.qpdjg.all_for.Adater;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qpdjg.all_for.Custom.CustomViewPager;
import com.example.qpdjg.all_for.Item.CategoryDetailItem;
import com.example.qpdjg.all_for.R;

import java.util.ArrayList;

public class CategoryDetailAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<CategoryDetailItem> data;
    private int layout;
    Context context;
    CustomViewPager viewPager;

    public CategoryDetailAdapter(Context context, int layout, ArrayList<CategoryDetailItem> data, CustomViewPager viewPager){
        this.context = context;
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data=data;
        this.layout=layout;
        this.viewPager =viewPager;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CategoryDetailItem getItem(int i) {
        return data.get(i);
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
        ImageView stars[]= new ImageView[5];

        ImageView icon = convertView.findViewById(R.id.detail_item_icon);
        TextView name = convertView.findViewById(R.id.detail_item_name);
        TextView subname = convertView.findViewById(R.id.detail_item_subname);

        stars[0] = convertView.findViewById(R.id.detail_item_star1);
        stars[1] = convertView.findViewById(R.id.detail_item_star2);
        stars[2] = convertView.findViewById(R.id.detail_item_star3);
        stars[3] = convertView.findViewById(R.id.detail_item_star4);
        stars[4] = convertView.findViewById(R.id.detail_item_star5);

        Glide.with(convertView).load(data.get(i).getIcon()).into(icon);
        name.setText(data.get(i).getAppname());
        subname.setText(data.get(i).getSubname());

        int rank=data.get(i).getRank();
        for(int j =0; j <rank; ++j){
            stars[j].setBackground(ContextCompat.getDrawable(context,R.drawable.star_full));
        }


        final String  toAppCall = data.get(i).getAppname();
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(4);
                viewPager.getViewpagerAdapter().setAppCall(toAppCall);
            }
        });
        return convertView;
    }

    public void setData(ArrayList<CategoryDetailItem> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }
}
