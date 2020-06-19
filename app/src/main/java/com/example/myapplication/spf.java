package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class spf extends AppCompatActivity {
EditText name,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spf);
        name=findViewById(R.id.ev1);
        age=findViewById(R.id.ev2);

    }

    @Override
    protected void onResume() {
        super.onResume();

    SharedPreferences s= getSharedPreferences("SF",0);
    String s1=s.getString("name","");
    int a= s.getInt("age",0);
    name.setText(s1);
    age.setText(String.valueOf(a));

}

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences s=getSharedPreferences("SF",0);
        SharedPreferences.Editor me=s.edit();
        String z=name.getText().toString();
        int y=Integer.parseInt(age.getText().toString());
//        String y=String.valueOf(age.getText());
//        String y=age.getText().toString();
        me.putString("name",z);
//        me.putString("age",y);
        me.putInt("age",y);
        me.commit();

    }
}