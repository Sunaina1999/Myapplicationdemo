package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class radio extends AppCompatActivity {
RadioGroup rg;
RadioButton m,f,rs;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        rg=findViewById(R.id.rg);
        m=findViewById(R.id.male);
        f=findViewById(R.id.female);
        b=findViewById(R.id.ok);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sid=rg.getCheckedRadioButtonId();
                rs=findViewById(sid);
                Toast.makeText(radio.this, rs.getText() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}