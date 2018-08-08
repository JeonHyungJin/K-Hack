package com.example.qpdjg.all_for.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.qpdjg.all_for.R;

public class StartPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        Button startapp = (Button)findViewById(R.id.StartAppButton);
        startapp.setText(R.string.startapp);

        startapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartPageActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
