package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.Date;

public class attendance extends AppCompatActivity {
TextView t1,t2;
RecyclerView prv;
FirebaseFirestore fb;
Users1 u1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        prv=findViewById(R.id.prv);
//        t1=findViewById(R.id.attname);
//        t2=findViewById(R.id.attuerid);
//        fb=FirebaseFirestore.getInstance();
//        fb.collection("Student").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if(task.isSuccessful())
//                {
//                    for(QueryDocumentSnapshot queryDocumentSnapshot:task.getResult())
//                    { u1=queryDocumentSnapshot.toObject(Users1.class);
//                String fbusername=u1.getName();
//                String fbuserid=u1.getUserid();
//                Toast.makeText(attendance.this, ""+fbusername+fbuserid, Toast.LENGTH_SHORT).show();
//            }}
//        }}).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(attendance.this, "failed", Toast.LENGTH_SHORT).show();
//            }
//        });
}}