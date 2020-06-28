package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class timetable extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Spinner sp;
String[] days={"Mon-Tue","Mon-Wed","Mon-Thrus","Mon-Fri"};
EditText e1,e2,e3,e4,s1,s2;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        e1=findViewById(R.id.edtsem);
        e2=findViewById(R.id.tsl);
        e3=findViewById(R.id.btimes);
        s1=findViewById(R.id.subs1);
        s2=findViewById(R.id.subss);
        b=findViewById(R.id.timemana);
sp=findViewById(R.id.pant);
        sp.setOnItemSelectedListener(this);
        ArrayAdapter a=new ArrayAdapter(this,android.R.layout.simple_list_item_1,days);
        a.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp.setAdapter(a);

b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String m=sp.getSelectedItem().toString();
        String n=e3.getText().toString();
        String o=e2.getText().toString();
        String p=s1.getText().toString();
        String q=s2.getText().toString();
        Intent i=new Intent(getApplicationContext(),tablegrid.class);
        i.putExtra("ke","m");
        i.putExtra("ke1","e3");
        i.putExtra("ke2","o");
        i.putExtra("ke3","p");
        i.putExtra("ke4","q");
        startActivity(i);
    }
});
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, days[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}