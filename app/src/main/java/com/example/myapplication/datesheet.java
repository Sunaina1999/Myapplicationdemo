package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class datesheet extends AppCompatActivity {
//EditText e1,e2;
//Button b1,b2,b3;
WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datesheet);
        wv=findViewById(R.id.webb3);
        wv.loadUrl("https://papuan-remains.000webhostapp.com/");
        wv.getSettings().setJavaScriptEnabled(true);

    }
}