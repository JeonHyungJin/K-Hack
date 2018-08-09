package com.example.qpdjg.all_for.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qpdjg.all_for.Activity.LoginActivity;
import com.example.qpdjg.all_for.Activity.ProfileActivity;
import com.example.qpdjg.all_for.R;
import com.example.qpdjg.all_for.Util.Profile_data;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;
import java.util.List;

public class MypageFragment extends Fragment {

    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private Button buttonLogout;
    private TextView textivewDelete;
    private FirebaseDatabase database =  FirebaseDatabase.getInstance();
    private DatabaseReference mReference = database.getReference();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.fragment_mypage,container,false);
        //initializing views
        textViewUserEmail = linearLayout.findViewById(R.id.email_text);
        buttonLogout = (Button) linearLayout.findViewById(R.id.buttonLogout);
        textivewDelete = (TextView) linearLayout.findViewById(R.id.textviewDelete);
        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();
        //유저가 로그인 하지 않은 상태라면 null 상태이고 이 액티비티를 종료하고 로그인 액티비티를 연다.
        if(firebaseAuth.getCurrentUser() == null) {
           // finish();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);

        }
        //유저가 있다면, null이 아니면 계속 진행
        FirebaseUser user = firebaseAuth.getCurrentUser();
        //textViewUserEmail의 내용을 변경해 준다.
        textViewUserEmail.setText(R.string.nice+"\n"+ user.getEmail()+R.string.as_login);
        //logout button event

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    firebaseAuth.signOut();
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);

            }
        });
        textivewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tokenID = FirebaseInstanceId.getInstance().getToken();
                mReference = database.getReference("UserProfile/"+tokenID);

                AlertDialog.Builder alert_confirm = new AlertDialog.Builder(getActivity());
                alert_confirm.setMessage(R.string.want_delete).setCancelable(false).setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                mReference.removeValue();
                                user.delete()
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(getActivity(), R.string.delete_your_acc, Toast.LENGTH_LONG).show();
                                                startActivity(new Intent(getActivity().getApplicationContext(), LoginActivity.class));
                                            }
                                        });
                            }
                        }
                );
                alert_confirm.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), R.string.cancel, Toast.LENGTH_LONG).show();
                    }
                });
                alert_confirm.show();
            }

        });

        TextView Email_Text = (TextView)linearLayout.findViewById(R.id.email_text);
        final TextView Point_Text = (TextView)linearLayout.findViewById(R.id.point_text);

        final String tokenID = FirebaseInstanceId.getInstance().getToken();

        DatabaseReference ProfileRef = mReference.child("UserProfile");

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    String FB_Point = ds.child("Point").getValue(String.class);
                    String FB_firebaseKey = ds.child("firebaseKey").getValue(String.class);
                    String FB_Name = ds.child("UserName").getValue(String.class);

                    if(tokenID.equals(FB_firebaseKey)){
                        Point_Text.setText(FB_Point+"Point");
                        break;
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        ProfileRef.addListenerForSingleValueEvent(valueEventListener);

        /*for(int i = 0;i<Profile_list.size();i++){
            if(tokenID.equals(Profile_list.get(i).firebaseKey)){
                System.out.println("내포인트"+Profile_list.get(i).Point);
            }
        }*/
        Email_Text.setText(user.getEmail());

        return linearLayout;
    }
}