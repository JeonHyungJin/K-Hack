package com.example.qpdjg.all_for.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ViewAppFragment extends Fragment {
    String appCall;
    ImageView star[] = new ImageView[5];
    TextView appname;
    ImageView icon;
    LinearLayout download;

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
        LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.fragment_appview,container,false);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contentPanel, fragment2);
        fragmentTransaction.commit();

        star[0] = (ImageView)linearLayout.findViewById(R.id.detail_item_star1);
        star[1] = (ImageView)linearLayout.findViewById(R.id.detail_item_star2);
        star[2] = (ImageView)linearLayout.findViewById(R.id.detail_item_star3);
        star[3] = (ImageView)linearLayout.findViewById(R.id.detail_item_star4);
        star[4] = (ImageView)linearLayout.findViewById(R.id.detail_item_star5);

        appname = (TextView)linearLayout.findViewById(R.id.detail_item_name);
        icon = (ImageView)linearLayout.findViewById(R.id.detail_item_icon);
        download = (LinearLayout)linearLayout.findViewById(R.id.detail_item_download);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + downloadUrl)));
            }
        });


        return linearLayout;
    }

    public void setAppCall(String appCall) {
        this.appCall = appCall;
//        appcall db내 앱이름으로 불러옴
//        String형 name
//        String형  url
//        String형 downloadUrl                예시)https://play.google.com/store/apps/details?id=com.nexon.fo4m 라면   com.nexon.fo4m 요부분만
//        int형 rank
//        Arraylist<String>  urlArray 설명 이미지 어레이
        // ArrayList<CommentItem> comment 코멘트 어레이
        //설정 바람

        fragment2.setData(urlArray,comment);
        setViews();
    }

    private void setViews(){
        appname.setText(name);
        Glide.with(getContext()).load(url).into(icon);
        for(int i =0; i< rank; ++i){
            star[i].setBackground(ContextCompat.getDrawable(getContext(),R.drawable.star_full));
        }
    }


}
