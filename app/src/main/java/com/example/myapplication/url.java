package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class url extends AppCompatActivity {
    EditText e1;
Button btnclick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);
        e1=findViewById(R.id.edt_url);
        btnclick=findViewById(R.id.btn_click);
        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=(e1.getText()).toString();
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://"+a));
                startActivity(i);

            }
        });
    }
}