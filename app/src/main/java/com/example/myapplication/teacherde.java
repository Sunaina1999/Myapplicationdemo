package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

public class teacherde extends AppCompatActivity {
EditText e1,e2,e3;
Button b1,b2,b3;
    String name,contact,mail;
    FirebaseFirestore fb;
    Users2 users2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherde);
        fb=FirebaseFirestore.getInstance();
        e1=findViewById(R.id.dett1);
        e2=findViewById(R.id.dett3);
        e3=findViewById(R.id.dett5);
        b1=findViewById(R.id.bdde);
        b2=findViewById(R.id.bdde1);
        b3=findViewById(R.id.bdde2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=e1.getText().toString();
                mail=e3.getText().toString();
                contact=e2.getText().toString();
                users2=new Users2( name,mail,contact);
                fb.collection("Teachers Info").document(name).set(users2).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(teacherde.this, "Details Added", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(teacherde.this, "Invalid details", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=e1.getText().toString();
                mail=e3.getText().toString();
                contact=e2.getText().toString();
                fb.collection("Teachers Info").document(name).update("name",name,"mail",mail,"contact",contact)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(teacherde.this, "Data update", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(teacherde.this, "Failure due to"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=e1.getText().toString();
                mail=e3.getText().toString();
                contact=e2.getText().toString();
                fb.collection("Teachers Info").document(name).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(teacherde.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(teacherde.this, "Failed due to"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}