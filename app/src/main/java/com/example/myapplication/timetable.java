package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class timetable extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Spinner sp;
String[] days={"Monday-Tuesday","Monday-Wednesday","Monday-Thrusday","Monday-Friday","Mondy-Saturday"};
EditText e1,e2,e3,e4;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        e1=findViewById(R.id.edtsem);
        e2=findViewById(R.id.tsl);
        e3=findViewById(R.id.btimes);
        e4=findViewById(R.id.subs);
        b=findViewById(R.id.timemana);
sp=findViewById(R.id.spinne);
sp.setOnItemSelectedListener(this);
ArrayAdapter a=new ArrayAdapter(this,android.R.layout.simple_list_item_1,days);
a.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
sp.setAdapter(a);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, days[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}