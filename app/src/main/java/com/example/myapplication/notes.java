package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class notes extends AppCompatActivity {
WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        wv=findViewById(R.id.webb);
        wv.loadUrl("https://papuan-remains.000webhostapp.com/");
        wv.getSettings().setJavaScriptEnabled(true);

    }
}