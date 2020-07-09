package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class forgotpass extends AppCompatActivity {
EditText e2;
Button b11;
    String countrycode, mobile, usermobile;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);
        e2=findViewById(R.id.cnewpass);
        b11=findViewById(R.id.forgotpassw);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog = new ProgressDialog(forgotpass.this,R.style.CustomDialogTheme);
                progressDialog.setTitle("Please wait...");
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(false);
                (findViewById(R.id.phse)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mobile=e2.getText().toString();
                        if (mobile.isEmpty() || mobile.length() < 10) {
                            e2.setError("Enter a Valid Mobile Number...");
                            e2.requestFocus();
                            return;
                        }
                        else{
                            progressDialog.show();
                            mobile=e2.getText().toString();
                            countrycode = "+91";
                            usermobile = countrycode + mobile;
                            Intent intent = new Intent(getApplicationContext(), otp.class);
                            intent.putExtra("UserMobile", mobile);
                            startActivity(intent);
                        }
                    }
                });

            }
        });
    }
}