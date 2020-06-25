package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class forgotpass extends AppCompatActivity {
EditText e1,e2;
Button b11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);
        e1=findViewById(R.id.newpass);
        e2=findViewById(R.id.cnewpass);
        b11=findViewById(R.id.forgotpassw);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(forgotpass.this,first.class);
                startActivity(i);
            }
        });
    }
}