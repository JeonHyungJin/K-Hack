package com.example.qpdjg.all_for.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qpdjg.all_for.Adater.CategoryDetailAdapter;
import com.example.qpdjg.all_for.Custom.CustomViewPager;
import com.example.qpdjg.all_for.Item.CategoryDetailItem;
import com.example.qpdjg.all_for.R;

import java.util.ArrayList;

public class CategoryDetailFragment extends Fragment {
    String toCall;
    TextView detail;
    ListView detail_list;
    CustomViewPager viewPager;
    CategoryDetailAdapter categoryDetailAdapter;
    ArrayList<CategoryDetailItem> data  = new ArrayList<CategoryDetailItem>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_cataory_detail, container, false);
        detail = (TextView)linearLayout.findViewById(R.id.detail);
        detail_list = (ListView)linearLayout.findViewById(R.id.detail_list);

        categoryDetailAdapter = new CategoryDetailAdapter(getContext(),R.layout.item_detail,data,viewPager);
        detail_list.setAdapter(categoryDetailAdapter);
        return linearLayout;
    }

    public void setToCall(String toCall) {
        this.toCall = toCall;
        detail.setText(toCall);

        //////////////////////////data에 리스트 요소를 채워주세요//////////////////////////////
        /*
            toCall returns 대소문자 구별해야함
            - transport
            - restaurant
            - delivery
            - property
            - travel
        * */


        //////////////////////////////////////////////////////////

        categoryDetailAdapter.setData(data);
        categoryDetailAdapter.notifyDataSetChanged();
    }
    public void setViewPager(CustomViewPager viewPager) {
        this.viewPager = viewPager;
    }

}
