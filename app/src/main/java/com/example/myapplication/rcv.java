package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class rcv extends AppCompatActivity {
RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcv);
    rv=findViewById(R.id.rv);
    lidata[] lidata=new lidata[]
            {
                    new lidata("call",android.R.drawable.ic_menu_call),
                    new lidata("menu",android.R.drawable.ic_menu_sort_by_size),
                    new lidata("alarm",android.R.drawable.ic_lock_idle_alarm),


            };
    rvad rvad=new rvad(lidata);
    rv.setLayoutManager(new LinearLayoutManager(this));
    rv.setAdapter(rvad);

    }
}