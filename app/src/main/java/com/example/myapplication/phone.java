package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class phone extends AppCompatActivity {
    private EditText editTextMobile;
    String countrycode, mobile, usermobile;
    ProgressDialog progressDialog;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        editTextMobile = findViewById(R.id.phmo);
        progressDialog = new ProgressDialog(this, R.style.CustomDialogTheme);
        progressDialog.setTitle("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        (findViewById(R.id.phse)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobile=editTextMobile.getText().toString();
                if (mobile.isEmpty() || mobile.length() < 10) {
                    editTextMobile.setError("Enter a Valid Mobile Number...");
                    editTextMobile.requestFocus();
                    return;
                }
                else{
                    progressDialog.show();
                    mobile=editTextMobile.getText().toString();
                    countrycode = "+91";
                    usermobile = countrycode + mobile;
                    Intent intent = new Intent(getApplicationContext(), otp.class);
                    intent.putExtra("UserMobile", mobile);
                    startActivity(intent);
                }
            }
        });

}}