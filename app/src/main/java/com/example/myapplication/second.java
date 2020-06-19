package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class second extends AppCompatActivity {
    EditText edtfname, edtlname, edtpassword, edtcpassword, edtemail, edtcontact;
    Button btnsubmit;
    TextView g;
    RadioGroup rg;
    RadioButton male, female;
    CheckBox ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        edtfname = findViewById(R.id.edt_fname);
        edtlname = findViewById(R.id.edt_lname);
        edtpassword = findViewById(R.id.edt_password);
        edtcpassword = findViewById(R.id.edt_cpassword);
        edtemail = findViewById(R.id.edt_email);
        edtcontact = findViewById(R.id.edt_contact);
        g = findViewById(R.id.g);
        rg = findViewById(R.id.rg);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
//        if(male.isChecked())
//        {
//            Toast.makeText(this, "Male", Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            Toast.makeText(this, "Female", Toast.LENGTH_SHORT).show();
//        }
        ch = findViewById(R.id.ch);
        btnsubmit = findViewById(R.id.btn_submit);
        Intent i = getIntent();
        String msg = i.getStringExtra("key_1");
        edtfname.setText(msg);
        String a=i.getStringExtra("key_2");
        edtpassword.setText(a);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtpassword.getText().toString().equals(edtcpassword.getText().toString()))
                {
                    Toast.makeText(second.this, "Password match", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(second.this, "Password does not match", Toast.LENGTH_SHORT).show();
                }
                Intent ii=new Intent(second.this,home.class);
                startActivity(ii);
            }
        });
    }
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences s= getSharedPreferences("Sf",0);
        String s1=s.getString("name","");
        int cc=s.getInt("password",0);
        edtfname.setText(s1);
        edtpassword.setText(String.valueOf(cc));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences s=getSharedPreferences("Sf",0);
        SharedPreferences.Editor ee=s.edit();
        String s1=edtfname.getText().toString();
        int cc=Integer.parseInt(edtcpassword.getText().toString());
        ee.putString("name",s1);
        ee.putInt("password",cc);
        ee.commit();
    }

}