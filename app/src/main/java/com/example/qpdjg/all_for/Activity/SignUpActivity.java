package com.example.qpdjg.all_for.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qpdjg.all_for.R;
import com.example.qpdjg.all_for.Util.Profile_data;
import com.example.qpdjg.all_for.Util.TitlebarActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class SignUpActivity extends TitlebarActivity implements View.OnClickListener{

    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    //define view objects
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextPassword_confirm;
    EditText editTextName;
    Button buttonSignup;
    TextView textviewSingin;
    TextView textviewMessage;
    ProgressDialog progressDialog;
    //define firebase object
    FirebaseAuth firebaseAuth;
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mReference = mDatabase.getReference();
    private ChildEventListener mChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

        TextView Signup_text = (TextView)findViewById(R.id.Signup);
        TextView Signup_explain_text = (TextView)findViewById(R.id.Signup_explain);

        //initializing views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPassword_confirm = (EditText)findViewById(R.id.editTextPassword_confirm);
        textviewSingin= (TextView) findViewById(R.id.textViewSignin);
        textviewMessage = (TextView) findViewById(R.id.textviewMessage);
        buttonSignup = (Button) findViewById(R.id.buttonSignup);
        progressDialog = new ProgressDialog(this);
        editTextName = findViewById(R.id.editTextName);
        //button click event
        buttonSignup.setOnClickListener(this);
        textviewSingin.setOnClickListener(this);

        //언어별로 변경되는 부분
        editTextEmail.setHint(R.string.plz_enter_email);
        editTextPassword.setHint(R.string.plz_enter_Password);
        editTextPassword_confirm.setHint(R.string.plz_enter_Password);
        editTextName.setHint(R.string.plz_enter_Name);
        Signup_text.setText(R.string.Signup);
        Signup_explain_text.setText(R.string.Signup_explain);
        buttonSignup.setText(R.string.Signup);
        textviewSingin.setText(R.string.If_member_signin);

    }
    //Firebse creating a new user
    private void registerUser(){
        //사용자가 입력하는 email, password를 가져온다.
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String password_confirm = editTextPassword_confirm.getText().toString().trim();
        String tokenID = FirebaseInstanceId.getInstance().getToken();
        //        mReference.child("message").push().setValue("2");
        mReference = mDatabase.getReference("UserProfile");
        if(!TextUtils.isEmpty(tokenID)) {
            Profile_data profile_data = new Profile_data();
            profile_data.firebaseKey = tokenID;
            profile_data.UserName = editTextName.getText().toString().trim();
            profile_data.Point = "0";
            profile_data.E_mail = email;
            mReference.child(tokenID).setValue(profile_data);
        }

        //email과 password가 비었는지 아닌지를 체크 한다.
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, R.string.enter_email, Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, R.string.enter_password, Toast.LENGTH_SHORT).show();
            return;
        }
        if(!(password.equals(password_confirm))){
            Toast.makeText(this, R.string.password_notequal, Toast.LENGTH_SHORT).show();
            return;
        }
        if(editTextName.getText().toString().trim().equals("")){
            Toast.makeText(this, R.string.enter_name, Toast.LENGTH_SHORT).show();
            return;
        }

        //email과 password가 제대로 입력되어 있다면 계속 진행된다.
        progressDialog.setMessage(getResources().getString(R.string.process_wait));
        progressDialog.show();
        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            //에러발생시
                            textviewMessage.setText(R.string.signup_error_type);
                            Toast.makeText(SignUpActivity.this, R.string.signup_error, Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }
    //button click event
    @Override
    public void onClick(View view) {
        if(view == buttonSignup) {
            //TODO
            registerUser();
        }
        if(view == textviewSingin) {
            //TODO
            finish();
            startActivity(new Intent(this, LoginActivity.class)); //추가해 줄 로그인 액티비티
        }

    }
    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime)
        {
            super.onBackPressed();
        }
        else
        {
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(), R.string.double_press_end, Toast.LENGTH_SHORT).show();
        }
    }
}

