package com.example.qpdjg.all_for.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.qpdjg.all_for.Adater.CategoryDetailAdapter;
import com.example.qpdjg.all_for.Custom.CustomViewPager;
import com.example.qpdjg.all_for.Item.CategoryDetailItem;
import com.example.qpdjg.all_for.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    ImageView detail_icon;
    ArrayList<CategoryDetailItem> data = new ArrayList<CategoryDetailItem>();
    ArrayList<CategoryDetailItem> return_data = new ArrayList<CategoryDetailItem>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_cataory_detail, container, false);
        detail = (TextView) linearLayout.findViewById(R.id.detail);
        detail_icon = (ImageView) linearLayout.findViewById(R.id.detail_icon);
        detail_list = (ListView) linearLayout.findViewById(R.id.detail_list);
        categoryDetailAdapter = new CategoryDetailAdapter(getContext(), R.layout.item_detail, data, viewPager);
        detail_explain = (TextView) linearLayout.findViewById(R.id.detail_explain);
        detail_list.setAdapter(categoryDetailAdapter);

        return linearLayout;
    }

    public ArrayList DB_read(String datail_category) {
        /*DB*/
        return_data.clear();
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference category_Ref = rootRef.child("app_category");
        DatabaseReference delivery_Ref = category_Ref.child(datail_category);
        DatabaseReference delivery_apps_Ref = delivery_Ref.child("apps");

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    System.out.println(ds.getKey().toString().trim());
                    System.out.println(ds.child("app_img").getValue().toString().trim());
                    return_data.add(new CategoryDetailItem(ds.getKey().toString().trim(), "sub", (float) 2.0, ds.child("app_img").getValue().toString().trim()));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        delivery_apps_Ref.addListenerForSingleValueEvent(valueEventListener);

        return return_data;
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
        detail_icon.setImageResource(R.drawable.transport_black);
        data = DB_read("transport");
        detail_explain.setText(getText(R.string.introduceTrans));
    }

    private void setRestaurant() {
        detail.setText("Restaurant");
        detail_icon.setImageResource(R.drawable.restaurant_black);
        data = DB_read("restaurant");
        detail_explain.setText(getText(R.string.introduceRest));
    }

    private void setDelivery() {
        detail.setText("Food Delivery");
        detail_icon.setImageResource(R.drawable.food_delivery_black);
        data = DB_read("delivery");
        detail_explain.setText(getText(R.string.introduceDeli));

    }

    private void setProperty() {
        detail.setText("Real Property");
        detail_icon.setImageResource(R.drawable.house_black);
        data = DB_read("realstate");
        detail_explain.setText(getText(R.string.introducePro));
    }

    private void setTravel() {
        detail.setText("Travel");
        detail_icon.setImageResource(R.drawable.travel_black);
        data = DB_read("tour");
        detail_explain.setText(getText(R.string.introduceTravel));
    }


}
