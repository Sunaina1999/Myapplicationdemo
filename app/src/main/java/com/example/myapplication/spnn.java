package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

public class spnn extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Spinner spnr;

String[] color={"Orange","Green","White"};
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spnn);
        ll=findViewById(R.id.l);
        spnr=findViewById(R.id.span);
        spnr.setOnItemSelectedListener (this);
        ArrayAdapter aa= new ArrayAdapter(this,android.R.layout.simple_list_item_1,color);
        aa.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spnr.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        view=this.getWindow().getDecorView();
        if(position==0)
        {
            ll.setBackgroundColor(Color.parseColor("#FF6D00"));
//         view.setBackgroundColor(Color.parseColor("#FF6D00"));
//            view.setBackgroundResource(R.color.DarkerGray);
        }
        else if(position==1)
        {
            ll.setBackgroundColor(Color.parseColor("#76FF03"));
//            view.setBackgroundColor(Color.parseColor("#76FF03"));
//            view.setBackgroundResource(R.color.DarkOrange);
        }
        else
        {
            ll.setBackgroundColor(Color.parseColor("#FFFFFF"));
//            view.setBackgroundColor(Color.parseColor("#FFFFFF"));
//            view.setBackgroundResource(R.color.White);
        }
        Toast.makeText(this, color[position], Toast.LENGTH_SHORT).show();
    }


    public void onNothingSelected(AdapterView<?> parent) {

    }
}