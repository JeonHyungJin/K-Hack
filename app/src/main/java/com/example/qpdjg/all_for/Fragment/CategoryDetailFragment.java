package com.example.qpdjg.all_for.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qpdjg.all_for.R;

public class CategoryDetailFragment extends Fragment {
    String toCall;
    TextView detail;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_cataory_detail, container, false);
        detail = (TextView)linearLayout.findViewById(R.id.detail);
        return linearLayout;
    }

    public void setToCall(String toCall) {
        this.toCall = toCall;
        detail.setText(toCall);
    }
}
