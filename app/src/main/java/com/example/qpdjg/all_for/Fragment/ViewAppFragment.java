package com.example.qpdjg.all_for.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qpdjg.all_for.Item.CommentItem;
import com.example.qpdjg.all_for.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;

public class ViewAppFragment extends Fragment {
    String appCall;
    String category;
    ImageView star[] = new ImageView[5];
    TextView appname;
    ImageView icon;
    LinearLayout download;
    Locale lang;
    String name;
    String url;
    String downloadUrl;
    int rank;
    ArrayList<String> urlArray = new ArrayList<String>();
    ArrayList<CommentItem> comment = new ArrayList<CommentItem>();
    ListFragment fragment2 = new ListFragment();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_appview, container, false);


        TextView translated = linearLayout.findViewById(R.id.translated);
        TextView Review = linearLayout.findViewById(R.id.Review);
        TextView introduce =linearLayout.findViewById(R.id.Introduce);
        TextView regis = linearLayout.findViewById(R.id.register);
        TextView comment_section = linearLayout.findViewById(R.id.comment_section);
        TextView download_section = linearLayout.findViewById(R.id.download_button);

        if(translated != null){
            translated.setText(R.string.translated);
        }
        if(Review != null){
            Review.setText(R.string.review);
        }
        if(introduce != null){
            introduce.setText(R.string.introduce);
        }
        if(regis != null){
            regis.setText(R.string.register);
        }
        if(comment_section != null) {
            comment_section.setText(R.string.comment_section);
        }
        if(download_section != null) {
            download_section.setText(R.string.download);
        }


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contentPanel, fragment2);
        fragmentTransaction.commit();

        star[0] = (ImageView) linearLayout.findViewById(R.id.detail_item_star1);
        star[1] = (ImageView) linearLayout.findViewById(R.id.detail_item_star2);
        star[2] = (ImageView) linearLayout.findViewById(R.id.detail_item_star3);
        star[3] = (ImageView) linearLayout.findViewById(R.id.detail_item_star4);
        star[4] = (ImageView) linearLayout.findViewById(R.id.detail_item_star5);

        appname = (TextView) linearLayout.findViewById(R.id.detail_item_name);
        icon = (ImageView) linearLayout.findViewById(R.id.detail_item_icon);
        download = (LinearLayout) linearLayout.findViewById(R.id.detail_item_download);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + downloadUrl)));
            }
        });


        return linearLayout;
    }




    public void setAppCall(final String appCall, String category) {


        this.appCall = appCall;
        this.category = category;

        fragment2.get_now(appCall,category);
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference app_Ref = rootRef.child("app_category");
        DatabaseReference category_Ref = app_Ref.child(category);
        DatabaseReference real_apps_Ref = category_Ref.child("apps");

        //        appcall db내 앱이름으로 불러옴
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Locale systemLocale = getResources().getConfiguration().locale;
                String strLanguage = systemLocale.getLanguage();


                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    if (appCall.equals(ds.getKey().toString())) {
                        name = ds.getKey();
                        url = ds.child("app_img").getValue().toString().trim();

                        downloadUrl = ds.child("download_url").getValue().toString().trim();

                        if (strLanguage == "zh") {
                            for (DataSnapshot ds3 : ds.child("explain_img").child("chienese_img").getChildren()) {
                                urlArray.add(ds3.getValue().toString().trim());
                            }
                        }else{
                            for (DataSnapshot ds3 : ds.child("explain_img").child("english_img").getChildren()) {
                                urlArray.add(ds3.getValue().toString().trim());
                            }
                        }

                        int aver_rank = 0;
                        int comments_size = 0;

                        for (DataSnapshot ds2 : ds.child("comments").getChildren()) {
                            CommentItem temp_comment = new CommentItem(ds2.child("rank").getValue().toString().trim(), ds2.child("date").getValue().toString().trim(), ds2.child("name").getValue().toString().trim(), ds2.child("contents").getValue().toString().trim());
                            comment.add(temp_comment);

                            aver_rank += Integer.parseInt(ds2.child("rank").getValue().toString().trim());
                            comments_size++;
                        }
                        if (comments_size != 0) {
                            aver_rank = aver_rank / comments_size;
                        } else {
                            aver_rank = 0;
                        }
                        rank = aver_rank;
                    }
                }
                System.out.println("여기인가요"+comment.size());
                fragment2.setData(urlArray, comment);
                setViews();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        };
        real_apps_Ref.addListenerForSingleValueEvent(valueEventListener);

//        String형 name/////////////////
//        String형  url///////////////
//        String형 downloadUrl                예시)https://play.google.com/store/apps/details?id=com.nexon.fo4m 라면   com.nexon.fo4m 요부분만
//        int형 rank /////////////////
//        Arraylist<String>  urlArray 설명 이미지 어레이/////////
        // ArrayList<CommentItem> comment 코멘트 어레이//////////
        //설정 바람

        //  fragment2.setData(urlArray, comment);
        //   setViews();
    }


    private void setViews() {
        appname.setText(name);
        Glide.with(getContext()).load(url).into(icon);
        for (int i = 0; i < rank; ++i) {
            star[i].setBackground(ContextCompat.getDrawable(getContext(), R.drawable.star_full));
        }
    }


}
