package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class listview extends AppCompatActivity {
    ListView lv;
    TextView tv;
    //String[] lines;
    String[] Subjects={"TOC","DAA","AI","ESAD","MMED"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        lv=findViewById(R.id.lv);
        tv=findViewById(R.id.tx);

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
    }
    }
