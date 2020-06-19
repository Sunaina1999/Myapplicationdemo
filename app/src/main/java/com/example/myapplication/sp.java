package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class sp extends AppCompatActivity {
EditText n,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        n=findViewById(R.id.n1);
        p=findViewById(R.id.p);

    }

    protected void onResume() {
        super.onResume();
        SharedPreferences s = getSharedPreferences("SP", 0);
        String s2 = s.getString("name", "");
        int b = s.getInt("password", 0);
        n.setText(s2);
        p.setText(String.valueOf(b));
    }


    protected void onPause() {
        super.onPause();
        SharedPreferences s= getSharedPreferences("SP",0);
        SharedPreferences.Editor e= s.edit();
        String q=n.getText().toString();
        int w=Integer.parseInt(p.getText().toString());
        e.putString("name",q);
        e.putInt("password",w);
        e.commit();


    }
}