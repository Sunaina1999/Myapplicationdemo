package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class in1 extends AppCompatActivity {
CheckBox c1,c2;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in1);
    c1=findViewById(R.id.ch_mark);
    c2=findViewById(R.id.ch_unmark);
    btn=findViewById(R.id.btn_submit);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Boolean cb=c1.isChecked();
            Boolean cb1=c2.isChecked();
            String a=cb.toString();
            String b=cb1.toString();
            Toast.makeText(in1.this,"one:"+a+"two:"+b,Toast.LENGTH_SHORT).show();


        }
    });
    }
}