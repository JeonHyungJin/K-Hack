package com.example.qpdjg.all_for.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.qpdjg.all_for.R;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ImageActivity   extends Activity {
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        url = getIntent().getStringExtra("url");



        ImageView imageView = findViewById(R.id.photo_view);
        Glide.with(this).load(url).into(imageView);


        PhotoViewAttacher attacher;
        attacher = new PhotoViewAttacher(imageView);

    }
}
