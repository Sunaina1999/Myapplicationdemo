package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class listview extends AppCompatActivity {
    ListView lv;
    TextView tv;
    //String[] lines;
    String[] Subjects={"TOC","DAA","AI","ESAD","MMED"};
SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        lv=findViewById(R.id.lv);
        tv=findViewById(R.id.tx);
mSwipeRefreshLayout=findViewById(R.id.swipe);
        //lines=getResources().getStringArray(R.array.festivals);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.lis,R.id.tx,Subjects);
       // final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,lines);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value= adapter.getItem(position);
                int a=position;
                Toast.makeText(listview.this,"" +value +a, Toast.LENGTH_SHORT).show();

            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                shuffle();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void shuffle() {
//        Collections.shuffle(Arrays.asList(Subjects),new Random(System.currentTimeMillis()));
        Toast.makeText(this, "Refreshing...", Toast.LENGTH_SHORT).show();
        int i=0;
        {
        switch(i)
        {
            case 0:
                Toast.makeText(this, "TOC", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "DAA", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "AI", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "ESAD", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "MMED", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}}
