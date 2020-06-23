package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class smpalarm extends AppCompatActivity {
Button b;
EditText t,a;
private int hr,min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smpalarm);
        a=findViewById(R.id.bet);
    b=findViewById(R.id.abt);
    b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Calendar c=Calendar.getInstance();
            hr=c.get(Calendar.HOUR);
            min=c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog=new TimePickerDialog(smpalarm.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    a.setText(hr+ ":"+min);
                }
            },hr,min,true);
            timePickerDialog.show();
            alrm();
        }
    });
    }
    private void alrm() {
        t=findViewById(R.id.aet);
        int i=Integer.parseInt(t.getText().toString());
    Intent it=new Intent(this,brdcst.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this,234,it,0);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(i*1000),pendingIntent);
        Toast.makeText(this, "Alarm set for"+i+"sec", Toast.LENGTH_SHORT).show();
    }
}
