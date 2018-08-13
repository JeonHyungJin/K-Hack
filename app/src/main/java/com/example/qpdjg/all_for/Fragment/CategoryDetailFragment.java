package com.example.qpdjg.all_for.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qpdjg.all_for.Activity.MainActivity;
import com.example.qpdjg.all_for.Adater.CategoryAdapter;
import com.example.qpdjg.all_for.Adater.CategoryDetailAdapter;
import com.example.qpdjg.all_for.Custom.CustomViewPager;
import com.example.qpdjg.all_for.Item.CategoryDetailItem;
import com.example.qpdjg.all_for.R;
import com.example.qpdjg.all_for.Util.Comment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class CategoryDetailFragment extends Fragment {
    String toCall;
    TextView detail;
    ListView detail_list;
    CustomViewPager viewPager;
    TextView detail_explain;
    CategoryDetailAdapter categoryDetailAdapter;
    Locale lang;
    ImageView detail_icon;
    String sub_String = null;
    Spinner spinner;
    String[] item;
    ArrayList<CategoryDetailItem> data = new ArrayList<CategoryDetailItem>();

    ArrayList<CategoryDetailItem> data1 = new ArrayList<CategoryDetailItem>();
    ArrayList<CategoryDetailItem> data2 = new ArrayList<CategoryDetailItem>();
    ArrayList<CategoryDetailItem> data3 = new ArrayList<CategoryDetailItem>();
    ArrayList<CategoryDetailItem> data4 = new ArrayList<CategoryDetailItem>();
    ArrayList<CategoryDetailItem> data5 = new ArrayList<CategoryDetailItem>();

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


        //spinner 언어 선택
        spinner = (Spinner) linearLayout.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                //  String show = getResources().getString(R.string.change_lang);
                String text = spinner.getSelectedItem().toString();
                if (text != "정렬방식") {
                    if (text == "평점순서") {
                        ArrayList temp = new ArrayList();
                        temp.add(data1);
                        temp.add(data2);
                        temp.add(data3);
                        temp.add(data4);
                        temp.add(data5);

                        for (int i = 0; i < temp.size(); i++) {
                            Collections.sort((List<CategoryDetailItem>) temp.get(i), new Comparator<CategoryDetailItem>() {
                                @Override
                                public int compare(CategoryDetailItem categoryDetailItem, CategoryDetailItem t1) {
                                    if (categoryDetailItem.getRank() > t1.getRank()) {
                                        return 1;
                                    } else if (categoryDetailItem.getRank() < t1.getRank()) {
                                        return -1;
                                    } else {
                                        return 0;
                                    }
                                }
                            });
                            Collections.reverse((List<?>) temp.get(i));
                        }
                        //평점 순으로 data 1~5 정렬
                    } else if (text == "한국인들이 많이 쓰는 순서") {
                        ArrayList temp = new ArrayList();
                        temp.add(data1);
                        temp.add(data2);
                        temp.add(data3);
                        temp.add(data4);
                        temp.add(data5);

                        for (int i = 0; i < temp.size(); i++) {
                            Collections.sort((List<CategoryDetailItem>) temp.get(i), new Comparator<CategoryDetailItem>() {
                                @Override
                                public int compare(CategoryDetailItem categoryDetailItem, CategoryDetailItem t1) {
                                    if (categoryDetailItem.getKorean_use_rank() > t1.getKorean_use_rank()) {
                                        return 1;
                                    } else if (categoryDetailItem.getKorean_use_rank() < t1.getKorean_use_rank()) {
                                        return -1;
                                    } else {
                                        return 0;
                                    }
                                }
                            });
                        }
                        //한국인이 많이 쓰는 순으로 data 1~5 정렬
                    } else if (text == "다운로드 많이 받은 순") {
                        ArrayList temp = new ArrayList();
                        temp.add(data1);
                        temp.add(data2);
                        temp.add(data3);
                        temp.add(data4);
                        temp.add(data5);

                        for (int i = 0; i < temp.size(); i++) {
                            Collections.sort((List<CategoryDetailItem>) temp.get(i), new Comparator<CategoryDetailItem>() {
                                @Override
                                public int compare(CategoryDetailItem categoryDetailItem, CategoryDetailItem t1) {
                                    if (categoryDetailItem.getDownload_rank() > t1.getDownload_rank()) {
                                        return 1;
                                    } else if (categoryDetailItem.getDownload_rank() < t1.getDownload_rank()) {
                                        return -1;
                                    } else {
                                        return 0;
                                    }
                                }
                            });
                        }
                        //다운로드 순으로 data 1~5 정렬
                    }
                    Configuration config = new Configuration();
                    config.locale = lang;
                    getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                    if (toCall == "transport") {
                        categoryDetailAdapter.setData(data1);
                    } else if (toCall == "restaurant") {
                        categoryDetailAdapter.setData(data2);
                    } else if (toCall == "delivery") {
                        categoryDetailAdapter.setData(data3);
                    } else if (toCall == "property") {
                        categoryDetailAdapter.setData(data5);
                    } else if (toCall == "travel") {
                        categoryDetailAdapter.setData(data4);
                    }

                    /*
                     *
                     * 여기 부분 까지 오면 data1 ~ data5가 원하는 정렬 방식으로 모두 정렬되있으니까 ListView만 새로고침해줘
                     *
                     * */
                    Toast.makeText(getActivity(), text + getResources().getString(R.string.change_lang), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        ArrayList<String> items = new ArrayList<String>();
        items.add("정렬방식");
        items.add("평점순서");
        items.add("한국인들이 많이 쓰는 순서");
        items.add("다운로드 많이 받은 순");
        ArrayAdapter<String> spiAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);
        spinner.setAdapter(spiAdapter);

        return linearLayout;
    }

    public ArrayList DB_read(String datail_category, final Context context) {
        final ArrayList<CategoryDetailItem> return_data = new ArrayList<CategoryDetailItem>();

        /*DB*/
        System.out.println(datail_category);
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference category_Ref = rootRef.child("app_category");
        DatabaseReference delivery_Ref = category_Ref.child(datail_category);
        DatabaseReference delivery_apps_Ref = delivery_Ref.child("apps");


        //final String finalSub_String = sub_String;
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                return_data.clear();
                ArrayList<Comment> commentArrayList = new ArrayList<Comment>();
                commentArrayList.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    int aver_rank = 0;
                    int comments_size = 0;

                    for (DataSnapshot ds2 : ds.child("comments").getChildren()) {
                        aver_rank += Integer.parseInt(ds2.child("rank").getValue().toString().trim());
                        comments_size++;
                    }
                    if (comments_size != 0) {
                        aver_rank = aver_rank / comments_size;
                    } else {
                        aver_rank = 0;
                    }

                    DatabaseReference ref = ds.getRef();

                    if (ref.getParent().getParent().toString().equals("https://all-for-b9d5b.firebaseio.com/app_category/transport")) {
                        sub_String = (String) context.getText(R.string.sub_transport);
                    } else if (ref.getParent().getParent().toString().equals("https://all-for-b9d5b.firebaseio.com/app_category/tour")) {
                        sub_String = (String) context.getText(R.string.sub_tour);
                    } else if (ref.getParent().getParent().toString().equals("https://all-for-b9d5b.firebaseio.com/app_category/realstate")) {
                        sub_String = (String) context.getText(R.string.sub_realstate);
                    } else if (ref.getParent().getParent().toString().equals("https://all-for-b9d5b.firebaseio.com/app_category/restaurant")) {
                        sub_String = (String) context.getText(R.string.sub_restaurant);
                    } else if (ref.getParent().getParent().toString().equals("https://all-for-b9d5b.firebaseio.com/app_category/delivery")) {
                        sub_String = (String) context.getText(R.string.sub_delivery);
                    }

                    return_data.add(new CategoryDetailItem(ds.getKey().toString().trim(), sub_String, aver_rank, ds.child("app_img").getValue().toString().trim(), Integer.parseInt(ds.child("download_rank").getValue().toString().trim()), Integer.parseInt(ds.child("korean_use_rank").getValue().toString().trim())));
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
        categoryDetailAdapter.notifyDataSetChanged();
    }

    public void setViewPager(CustomViewPager viewPager) {
        this.viewPager = viewPager;
    }

    private void setTransport() {
        detail.setText("Transport");
        detail_icon.setImageResource(R.drawable.transport_black);
        categoryDetailAdapter.setData(data1);
        detail_explain.setText(getText(R.string.introduceTrans));
    }

    private void setRestaurant() {
        detail.setText("Restaurant");
        detail_icon.setImageResource(R.drawable.restaurant_black);
        categoryDetailAdapter.setData(data2);
        detail_explain.setText(getText(R.string.introduceRest));
    }

    private void setDelivery() {
        detail.setText("Food Delivery");
        detail_icon.setImageResource(R.drawable.food_delivery_black);
        categoryDetailAdapter.setData(data3);
        detail_explain.setText(getText(R.string.introduceDeli));

    }

    private void setProperty() {
        detail.setText("Real Property");
        detail_icon.setImageResource(R.drawable.house_black);
        categoryDetailAdapter.setData(data5);
        detail_explain.setText(getText(R.string.introducePro));
    }

    private void setTravel() {
        detail.setText("Travel");
        detail_icon.setImageResource(R.drawable.travel_black);
        categoryDetailAdapter.setData(data4);
        detail_explain.setText(getText(R.string.introduceTravel));
    }

    public void dataRefresh(Context context) {
        data1 = DB_read("transport", context);
        data2 = DB_read("restaurant", context);
        data3 = DB_read("delivery", context);
        data4 = DB_read("tour", context);
        data5 = DB_read("realstate", context);
    }

}