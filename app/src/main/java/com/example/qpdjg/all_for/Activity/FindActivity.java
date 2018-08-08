package com.example.qpdjg.all_for.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qpdjg.all_for.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
public class FindActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "FindActivity";
    //define view objects
    private EditText editTextUserEmail;
    private Button buttonFind;
    private TextView textviewMessage;
    private ProgressDialog progressDialog;
    //define firebase object
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        TextView find_password = (TextView)findViewById(R.id.find_password);
        TextView find_explain = (TextView)findViewById(R.id.find_explain);
        editTextUserEmail = (EditText) findViewById(R.id.editTextUserEmail);
        buttonFind = (Button) findViewById(R.id.buttonFind);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        buttonFind.setOnClickListener(this);


        //언어 별 처리
        find_password.setText(R.string.find_password);
        find_explain.setText(R.string.find_password_explain);
        buttonFind.setText(R.string.find_password_send);
    }
    @Override
    public void onClick(View view) {
        if(view == buttonFind){
            progressDialog.setMessage(getResources().getString(R.string.process_wait));
            progressDialog.show();
            //비밀번호 재설정 이메일 보내기
            String emailAddress = editTextUserEmail.getText().toString().trim();
            firebaseAuth.sendPasswordResetEmail(emailAddress)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(FindActivity.this, R.string.sent_email, Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            } else {
                                Toast.makeText(FindActivity.this, R.string.fail_sending_email, Toast.LENGTH_LONG).show();
                            }
                            progressDialog.dismiss();
                        }
                    });
        }
    }
}