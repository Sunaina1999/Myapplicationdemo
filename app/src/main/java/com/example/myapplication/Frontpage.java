package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.common.base.Verify;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Frontpage extends AppCompatActivity {
private static int Timeout=200;
    FirebaseUser currentUser;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        currentUser=auth.getCurrentUser();
               new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(currentUser==null)
                {
                    Intent intent=new Intent(Frontpage.this, first.class);
                    startActivity(intent);
                }
                else
                {
                    String phone = currentUser.getPhoneNumber();
                    Intent intent=new Intent(Frontpage.this,home.class);
                startActivity(intent);
                finish();
                }
            }
        },Timeout);

    }
}