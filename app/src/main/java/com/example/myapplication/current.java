package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.TextView;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;

public class current extends AppCompatActivity {
TextView tv;
    SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        tv=findViewById(R.id.tvvv);
        mSwipeRefreshLayout=findViewById(R.id.swipe);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Calendar calendar= Calendar.getInstance();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm:ss");
                String dateTime=simpleDateFormat.format(calendar.getTime());
                tv.setText(dateTime);
                mSwipeRefreshLayout.setRefreshing(Boolean.parseBoolean(dateTime));
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

//        Collections.shuffle(Collections.singletonList(dateTime));

    }
}