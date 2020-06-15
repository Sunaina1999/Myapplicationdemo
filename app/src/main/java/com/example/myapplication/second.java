package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

public class second extends AppCompatActivity  {
    EditText edtfname,edtlname,edtpassword,edtcpassword,edtemail,edtcontact;
    Button btnsubmit;
    TextView g;
RadioGroup rg;
RadioButton male,female;
CheckBox ch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        edtfname=findViewById(R.id.edt_fname);
        edtlname=findViewById(R.id.edt_lname);
        edtpassword=findViewById(R.id.edt_password);
        edtcpassword=findViewById(R.id.edt_cpassword);
        edtemail=findViewById(R.id.edt_email);
        edtcontact=findViewById(R.id.edt_contact);
        g=findViewById(R.id.g);
        rg=findViewById(R.id.rg);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        ch=findViewById(R.id.ch);
        btnsubmit=findViewById(R.id.btn_submit);
        int r=rg.getCheckedRadioButtonId();
        boolean c=ch.isChecked();
        Intent i=getIntent();
        String msg=i.getStringExtra("key_1");
        edtfname.setText(msg);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }
}