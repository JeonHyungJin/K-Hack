package com.example.qpdjg.all_for.Fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qpdjg.all_for.Custom.CustomViewPager;
import com.example.qpdjg.all_for.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainFragment extends Fragment {
    Bitmap bitmap;
    CustomViewPager viewPager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_main, container, false);

        TextView suggest = (TextView) linearLayout.findViewById(R.id.suggest_t);
        TextView best = linearLayout.findViewById(R.id.best_t);
        TextView ad = linearLayout.findViewById(R.id.ad_t);

        suggest.setText(R.string.suggest);
        best.setText(R.string.best);
        ad.setText(R.string.ad);

        LinearLayout baemin = linearLayout.findViewById(R.id.horizon_app1);
        baemin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(4);
                viewPager.getViewpagerAdapter().setAppCall("배달의민족","delivery");
            }
        });

        TextView textView1 = (TextView) linearLayout.findViewById(R.id.horizon_description1_2);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.horizon_description2_2);
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.horizon_description3_2);
        TextView textView4 = (TextView) linearLayout.findViewById(R.id.horizon_description4_2);
        TextView textView5 = (TextView) linearLayout.findViewById(R.id.horizon_description5_2);

        textView1.setText(R.string.ca_restaurant);
        textView2.setText(R.string.ca_delivery);
        textView3.setText(R.string.ca_transport);
        textView4.setText(R.string.ca_realstate);
        textView5.setText(R.string.ca_tour);

        TextView textView6 = (TextView) linearLayout.findViewById(R.id.best_description1_2);
        TextView textView7 = (TextView) linearLayout.findViewById(R.id.best_description2_2);
        TextView textView8 = (TextView) linearLayout.findViewById(R.id.best_description3_2);

        textView6.setText(R.string.ca_restaurant);
        textView7.setText(R.string.ca_delivery);
        textView8.setText(R.string.ca_transport);


        ImageView imageView1 = (ImageView) linearLayout.findViewById(R.id.horizon_icon1);
        ImageView imageView2 = (ImageView) linearLayout.findViewById(R.id.horizon_icon2);
        ImageView imageView3 = (ImageView) linearLayout.findViewById(R.id.horizon_icon3);
        ImageView imageView4 = (ImageView) linearLayout.findViewById(R.id.horizon_icon4);
        ImageView imageView5 = (ImageView) linearLayout.findViewById(R.id.horizon_icon5);

        ImageView imageView6 = (ImageView) linearLayout.findViewById(R.id.best_icon1);
        ImageView imageView7 = (ImageView) linearLayout.findViewById(R.id.best_icon2);
        ImageView imageView8 = (ImageView) linearLayout.findViewById(R.id.best_icon3);


        network_image("https://lh3.googleusercontent.com/Zc6zChInlUNc7fGESdXJcBHrelfgXRB5TeJkhJ3N15noXE8O0RwcrLsgjuXyJQoUdmE=s360-rw", imageView1);
        network_image("https://lh3.googleusercontent.com/sz7a02Naspr5ANElxz2tPpcgwogBoSoHLPSm-mlYuIEiGjeo6ZzuwB3SDJ5M48Bfhe8=s360-rw", imageView2);
        network_image("https://lh3.googleusercontent.com/LvEJYY67s2TWTlmo0keXjNmG-WZ17wx0LgNMCcxYcfXuMJejxu_A5LI9ERvOJYNU8g=s360-rw", imageView3);
        network_image("https://lh3.googleusercontent.com/QBnly97i31doJhP6E_PF2cmzIuXFzbFBDnuiy_DkzjNJtcqAFwPHwLfCe0B0_z7a4fWO=s360-rw", imageView4);
        network_image("https://lh3.googleusercontent.com/WJD-xZb6qnlrdFaQyS2h5PHaXhEJ1-yHRcHfqJEpqlMRJuKZQA7Evxd_Dpip92Hsqe8=s360-rw", imageView5);

        network_image("https://lh3.googleusercontent.com/OJzhHQMc08Y1yUfjdL1F1Ohv2hjqgaPwyoMMbgg12qgh0C8dZf5pNOmiLDlwJidARCi_=s360-rw", imageView6);
        network_image("https://lh3.googleusercontent.com/NzeXFp0TGGcZoVSk_xzwdB567WurfscKr2j3pT5oKjWH00-tqBKF9LSnRK0sckgE7TQ=s360-rw", imageView7);
        network_image("https://lh3.googleusercontent.com/-aW4PDSH3gI8d2I7zKdYkhrWcRema_GRaov0PnDs15W9FHrzFL5FpN85MNJ1EHzpnCc=s360-rw", imageView8);


        return linearLayout;
    }

    public void network_image(final String url, ImageView im) {
        Thread mThread = new Thread() {
            @Override
            public void run() {
                try {
                    URL url2 = new URL(url);
                    HttpURLConnection conn = (HttpURLConnection) url2.openConnection();
                    conn.setDoInput(true);
                    conn.connect();

                    InputStream is = conn.getInputStream();
                    bitmap = BitmapFactory.decodeStream(is);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        mThread.start();
        try {
            mThread.join();
            im.setImageBitmap(bitmap);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setViewPager(CustomViewPager viewPager) {
        this.viewPager = viewPager;
    }
}
