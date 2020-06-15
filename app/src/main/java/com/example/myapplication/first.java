package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class first extends AppCompatActivity {
 EditText edtname,edtpassword;
 Button btnback,btnnext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        edtname=findViewById(R.id.edt_name);
        edtpassword=findViewById(R.id.edt_password);
        btnback=findViewById(R.id.btn_back);
        btnnext=findViewById(R.id.btn_next);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtname.getText().toString();
                Toast.makeText(getApplicationContext(),"Welcome "+name,Toast.LENGTH_SHORT).show();
                String a= (edtname.getText()).toString();
                Intent i=new Intent(getApplicationContext(),second.class);
                i.putExtra("key_1",a);
                startActivity(i);
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //customlayout
//                LayoutInflater li=getLayoutInflater();
//                View layout=li.inflate(R.layout.cst,(ViewGroup)findViewById(R.id.customtoast));
//                Toast t=new Toast(getApplicationContext());
//                t.setDuration(Toast.LENGTH_SHORT);
//                t.setView(layout);
//                t.show();
//                Intent intent=new Intent(getApplicationContext(),second.class);
//                startActivity(intent);
                finish();

            }
        });

    }

}