package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class webv extends AppCompatActivity {
WebView wv;
EditText e;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webv);
        e=findViewById(R.id.we);
        b=findViewById(R.id.bt);
        wv=findViewById(R.id.web);
        wv.loadUrl("https://developer.android.com/");

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                wv.getSettings().setJavaScriptEnabled(true);
                wv.setWebViewClient(new WebViewClient());
//                String a=(e.getText()).toString();
//                wv.loadUrl(a);
//                setData(Uri.parse("https://"+a));
//                Intent i=new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse("https://"+a));
//                startActivity(i);

            }
        });


    }
}