package com.example.qpdjg.all_for.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.qpdjg.all_for.Adater.CategoryDetailAdapter;
import com.example.qpdjg.all_for.Custom.CustomViewPager;
import com.example.qpdjg.all_for.Item.CategoryDetailItem;
import com.example.qpdjg.all_for.R;

import java.util.ArrayList;
import java.util.*;

public class CategoryDetailFragment extends Fragment {
    String toCall;
    TextView detail;
    ListView detail_list;
    CustomViewPager viewPager;
    TextView detail_explain;
    CategoryDetailAdapter categoryDetailAdapter;
    Locale lang;
    ArrayList<CategoryDetailItem> data = new ArrayList<CategoryDetailItem>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_cataory_detail, container, false);
        detail = (TextView) linearLayout.findViewById(R.id.detail);
        detail_list = (ListView) linearLayout.findViewById(R.id.detail_list);
        categoryDetailAdapter = new CategoryDetailAdapter(getContext(), R.layout.item_detail, data, viewPager);
        detail_explain = (TextView) linearLayout.findViewById(R.id.detail_explain);
        detail_list.setAdapter(categoryDetailAdapter);
        return linearLayout;
    }

    public void setToCall(String toCall) {

        this.toCall = toCall;

        Locale systemLocale = getResources().getConfiguration().locale;
        String strLanguage = systemLocale.getLanguage();
        if (toCall == "transport") {
            setTransport();
        } else if (toCall == "restaurant") {
            setRestaurant();
        } else if (toCall == "delivery") {
            setDelivery();
        } else if (toCall == "property") {
            setProperty();
        } else if (toCall == "travel") {
            setTravel();
        }
        categoryDetailAdapter.setData(data);
        categoryDetailAdapter.notifyDataSetChanged();
    }

    public void setViewPager(CustomViewPager viewPager) {
        this.viewPager = viewPager;
    }

    private void setTransport() {
        detail.setText("Transport");
        detail_explain.setText(getText(R.string.introduceTrans));
    }

    private void setRestaurant() {
        detail.setText("Restaurant");
        detail_explain.setText(getText(R.string.introduceRest));
    }

    private void setDelivery() {
        detail.setText("Food Delivery");
        detail_explain.setText(getText(R.string.introduceDeli));
    }

    private void setProperty() {
        detail.setText("Real Property");
        detail_explain.setText(getText(R.string.introducePro));
    }

    private void setTravel() {
        detail.setText("Travel");
        detail_explain.setText(getText(R.string.introduceTravel));
    }


}
