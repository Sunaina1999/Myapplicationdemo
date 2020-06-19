package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class spn extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Spinner spnr;
String[] fruits={"mango","apple","banana"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spn);
        spnr=findViewById(R.id.sp);
        spnr.setOnItemSelectedListener(this);
        ArrayAdapter aa= new ArrayAdapter(this,android.R.layout.simple_list_item_1,fruits);
        aa.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spnr.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, fruits[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}