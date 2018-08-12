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
import com.example.qpdjg.all_for.Item.CategoryItem;
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

        ArrayList<CategoryItem> data= new ArrayList<CategoryItem>();
        data.add(new CategoryItem(ContextCompat.getDrawable(getContext(),R.drawable.transport),getResources().getString(R.string.ca_transport),"transport"));
        data.add(new CategoryItem(ContextCompat.getDrawable(getContext(),R.drawable.restaurant),getResources().getString(R.string.ca_restaurant), "restaurant"));
        data.add(new CategoryItem(ContextCompat.getDrawable(getContext(),R.drawable.food_delivery),getResources().getString(R.string.ca_delivery), "delivery"));
        data.add(new CategoryItem(ContextCompat.getDrawable(getContext(),R.drawable.house),getResources().getString(R.string.ca_realstate), "property"));
        data.add(new CategoryItem(ContextCompat.getDrawable(getContext(),R.drawable.travel),getResources().getString(R.string.ca_tour), "travel"));


        CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(),R.layout.item_catagory,data,viewPager);

        catagoty = (ListView)linearLayout.findViewById(R.id.cataory_list);
        catagoty.setAdapter(categoryAdapter);


        return linearLayout;
    }

    public void setViewPager(CustomViewPager viewPager) {
        this.viewPager = viewPager;
    }
}
