package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class dtpick extends AppCompatActivity implements View.OnClickListener {
    Button btt;
EditText edt;
private int yr,mn,dt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtpick);
    btt=findViewById(R.id.bdt);
    edt=findViewById(R.id.edt);
    btt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Calendar c=Calendar.getInstance();
        yr=c.get(Calendar.YEAR);
        mn=c.get(Calendar.MONTH);
        dt=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
edt.setText(yr+ "-"+mn+"/" +dt);
            }
        },yr,mn,dt);
        datePickerDialog.show();
    }
}