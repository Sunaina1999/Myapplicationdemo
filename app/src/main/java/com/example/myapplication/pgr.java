package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class pgr extends AppCompatActivity {
Button pb;
ProgressDialog progressDialog;
    private Handler hdlr=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgr);
    pb=findViewById(R.id.pb);
    }
    public void clk(View view)
    {
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("workin progress");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgress(0);
        progressDialog.show();
        final int pt=100;
        Thread t=new Thread() {
            @Override
            public void run() {
                int jt = 0;
                while (jt < pt ) {
                    jt += 10;
                    hdlr.post(new Runnable()
                    {

                        @Override
                        public void run() {
//                            progressDialog.setProgress(jt);
                        }
                    });
                    try {
                        sleep(200);
                        jt += 10;
                        progressDialog.setProgress(jt);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        t.start();
    }
}