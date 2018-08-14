package com.example.qpdjg.all_for.Fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.qpdjg.all_for.Adater.CommentAdapter;
import com.example.qpdjg.all_for.Custom.ImageViewer;
import com.example.qpdjg.all_for.Item.CommentItem;
import com.example.qpdjg.all_for.R;
import com.example.qpdjg.all_for.Util.NoScrollBarListview;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    CommentAdapter commentAdapter;
    ImageViewer imageViewer;
    EditText editText;
    LinearLayout commentBtn;
    NoScrollBarListview  noScrollBarListview;
    ArrayList<CommentItem> comemnts = new ArrayList<CommentItem>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_content, container, false);
        commentAdapter = new CommentAdapter(getContext(),R.layout.item_comment,comemnts);
        imageViewer = (ImageViewer)linearLayout.findViewById(R.id.contentImageViewer);

        editText = (EditText)linearLayout.findViewById(R.id.contentEdittext);
        commentBtn = (LinearLayout)linearLayout.findViewById(R.id.contentComment);
        noScrollBarListview = (NoScrollBarListview)linearLayout.findViewById(R.id.contentCommentView);

        noScrollBarListview.setAdapter(commentAdapter);
        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = editText.getText().toString();
                if (txt.length() == 0){
                    Toast.makeText(getContext(),"내용을 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else{

                }
            }
        });

        return linearLayout;
    }

    public void setData( ArrayList<String> url,ArrayList<CommentItem> data ){
        imageViewer.setUrl(url);
        commentAdapter.setData(data);
    }
}
