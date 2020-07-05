package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class datesheet extends AppCompatActivity {
EditText e1,e2;
Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datesheet);
        e1=findViewById(R.id.dates11);
        e2=findViewById(R.id.dates1);
        b1=findViewById(R.id.dates2);
        b2=findViewById(R.id.dates3);
        b3=findViewById(R.id.dates4);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}