package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class notice extends AppCompatActivity {
EditText e1;
Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        e1=findViewById(R.id.not1);
        b1=findViewById(R.id.up1);
        b2=findViewById(R.id.up2);

    }
}