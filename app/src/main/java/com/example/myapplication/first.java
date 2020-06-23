package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jgabrielfreitas.core.BlurImageView;

public class first extends AppCompatActivity {
 EditText edtname,edtpassword;
 Button btnback,btnnext;
 BlurImageView blur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        edtname=findViewById(R.id.edt_name);
        edtpassword=findViewById(R.id.edt_password);
        blur=findViewById(R.id.Blurimage);
        blur.setBlur(10);
        btnback=findViewById(R.id.btn_back);
        btnnext=findViewById(R.id.btn_next);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtname.getText().toString();
               String pass= (edtpassword.getText().toString());
                Toast.makeText(getApplicationContext(),"Welcome "+name,Toast.LENGTH_SHORT).show();
//                String a= (edtname.getText()).toString();
                Intent i=new Intent(getApplicationContext(),second.class);
                i.putExtra("key_1",name);
                i.putExtra("key_2",pass);
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
                Intent ii=new Intent(getApplicationContext(),home.class);
                startActivity(ii);

            }
        });

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//            SharedPreferences s= getSharedPreferences("SF",0);
//            String s1=s.getString("name","");
//            int a= s.getInt("password",0);
//            edtname.setText(s1);
//            edtpassword.setText(String.valueOf(a));
//
//        }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        SharedPreferences s=getSharedPreferences("SF",0);
//        SharedPreferences.Editor ee=s.edit();
//        String z=edtname.getText().toString();
//        int y=Integer.parseInt(edtpassword.getText().toString());
//        ee.putString("name",z);
//        ee.putInt("age",y);
//        ee.commit();
//    }
}
