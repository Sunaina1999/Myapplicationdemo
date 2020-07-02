package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class second extends AppCompatActivity {
    EditText edtfname,edtpassword, edtcpassword, edtemail, edtcontact;
    Button btnsubmit;
    TextView g;
    RadioGroup rg;
    RadioButton male, female,rs;
    CheckBox ch;
    String name,pass,cpass,contact,email,gender;
        FirebaseFirestore fb;
     Users admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        fb=FirebaseFirestore.getInstance();
        edtfname = findViewById(R.id.edt_fname);
        edtpassword = findViewById(R.id.edt_password);
        edtcpassword = findViewById(R.id.edt_cpassword);
        edtemail = findViewById(R.id.edt_email);
        edtcontact = findViewById(R.id.edt_contact);
        rg = findViewById(R.id.rg1);
        male = findViewById(R.id.male1);
        female = findViewById(R.id.female1);
        ch = findViewById(R.id.ch);
                Intent i = getIntent();
        String msg = i.getStringExtra("key_1");
        edtfname.setText(msg);
        String a=i.getStringExtra("key_2");
        edtpassword.setText(a);
        btnsubmit = findViewById(R.id.btn_submit1);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sid=rg.getCheckedRadioButtonId();
                rs=findViewById(sid);
                name=edtfname.getText().toString();
                pass=edtpassword.getText().toString();
                cpass=edtcpassword.getText().toString();
                email=edtemail.getText().toString();
                contact=edtcontact.getText().toString();
                gender=male.getText().toString();
                gender=female.getText().toString();
                admin=new Users(name,pass,cpass,email,contact,gender);
//                Toast.makeText(second.this,rs.getText(), Toast.LENGTH_SHORT).show();

       fb.collection("Teacher").document(name).set(admin).addOnSuccessListener(new OnSuccessListener<Void>() {
           @Override
           public void onSuccess(Void aVoid) {
               Toast.makeText(second.this, "Details Added", Toast.LENGTH_SHORT).show();
           }
       }).addOnFailureListener(new OnFailureListener() {
           @Override
           public void onFailure(@NonNull Exception e) {
               Toast.makeText(second.this, "Invalid Details", Toast.LENGTH_SHORT).show();
           }
       });
                if(edtpassword.getText().toString().equals(edtcpassword.getText().toString()))
                {
                    Toast.makeText(second.this, "Password match", Toast.LENGTH_SHORT).show();
                    Intent ii=new Intent(second.this,home.class);
                    startActivity(ii);
                }
                else
                {
                    Toast.makeText(second.this, "Password does not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        SharedPreferences s= getSharedPreferences("Sf",0);
//        String s1=s.getString("name","");
//        int cc=s.getInt("password",0);
//        edtfname.setText(s1);
//        edtpassword.setText(String.valueOf(cc));
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        SharedPreferences s=getSharedPreferences("Sf",0);
//        SharedPreferences.Editor ee=s.edit();
//        String s1=edtfname.getText().toString();
//        int cc=Integer.parseInt(edtcpassword.getText().toString());
//        ee.putString("name",s1);
//        ee.putInt("password",cc);
//        ee.commit();
//    }

}
