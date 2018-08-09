package com.example.qpdjg.all_for.Adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qpdjg.all_for.Custom.CustomViewPager;
import com.example.qpdjg.all_for.Item.CatagoryItem;
import com.example.qpdjg.all_for.R;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<CatagoryItem> data;
    private int layout;
    private Context context;
    private CustomViewPager viewPager;
    public CategoryAdapter(Context context, int layout, ArrayList<CatagoryItem> data, CustomViewPager viewPager){
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
    public CatagoryItem getItem(int i) {
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
        ImageView icon = (ImageView)convertView.findViewById(R.id.catagory_icon);
        TextView txt = (TextView)convertView.findViewById(R.id.cataory_text);

        icon.setBackground(data.get(i).getIcon());
        txt.setText(data.get(i).getTxt());

        final String  toCall = data.get(i).gettoCall();
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(3);
                viewPager.getViewpagerAdapter().setToCall(toCall);
                //context.startActivity(intent);
            }
        });

        return convertView;
    }
}
