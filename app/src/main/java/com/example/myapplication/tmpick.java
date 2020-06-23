package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.time.Clock;
import java.util.Calendar;

public class tmpick extends AppCompatActivity implements View.OnClickListener {
EditText ed;
Button bt;
private int hr,min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmpick);
        ed=findViewById(R.id.edp);
        bt=findViewById(R.id.btn);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        Calendar c=Calendar.getInstance();
        hr=c.get(Calendar.HOUR);
        min=c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String AM_PM;
                if(hourOfDay<12)
                {
                    AM_PM="AM";
                }
                else
                {
                    AM_PM="PM";
                }
                ed.setText(hr+ ":"+min+ ""+AM_PM);
            }
        },hr,min,false);
        timePickerDialog.show();
    }
}