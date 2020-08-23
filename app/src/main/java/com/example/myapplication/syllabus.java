package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class syllabus extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        wv=findViewById(R.id.webb2);
        wv.loadUrl("https://papuan-remains.000webhostapp.com/");
        wv.getSettings().setJavaScriptEnabled(true);
    }
}