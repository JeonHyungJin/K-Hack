package com.example.qpdjg.all_for.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.qpdjg.all_for.Adater.CategoryAdapter;
import com.example.qpdjg.all_for.Custom.CustomViewPager;
import com.example.qpdjg.all_for.Item.CatagoryItem;
import com.example.qpdjg.all_for.R;

import java.util.ArrayList;

public class CategoryFragment extends Fragment{
    ListView catagoty;
    CategoryAdapter categoryAdapter;
    CustomViewPager viewPager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.fragment_catagory,container,false);

        ArrayList<CatagoryItem> data= new ArrayList<CatagoryItem>();
        data.add(new CatagoryItem(ContextCompat.getDrawable(getContext(),R.drawable.transport),"Public Transport","transport"));
        data.add(new CatagoryItem(ContextCompat.getDrawable(getContext(),R.drawable.restaurant),"Restaurant", "restaurant"));
        data.add(new CatagoryItem(ContextCompat.getDrawable(getContext(),R.drawable.food_delivery),"Food Delivery", "delivery"));
        data.add(new CatagoryItem(ContextCompat.getDrawable(getContext(),R.drawable.house),"Real Property", "property"));
        data.add(new CatagoryItem(ContextCompat.getDrawable(getContext(),R.drawable.travel),"Travel", "travel"));


        CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(),R.layout.item_catagory,data,viewPager);

        catagoty = (ListView)linearLayout.findViewById(R.id.cataory_list);
        catagoty.setAdapter(categoryAdapter);


        return linearLayout;
    }

    public void setViewPager(CustomViewPager viewPager) {
        this.viewPager = viewPager;
    }
}
