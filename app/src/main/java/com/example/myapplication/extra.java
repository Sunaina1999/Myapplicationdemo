package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class extra extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView date;
    TextView atroll,atstud;
    CheckBox uncheck ,check;
    FirebaseAuth auth;
    FirebaseFirestore db;
    Button btn;
    Student student;
    attendanceadapter attendAdapter;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        final String id=getIntent().getStringExtra("id");

        recyclerView = findViewById(R.id.prv);
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        date = findViewById(R.id.currentdate);
        check = findViewById(R.id.checkall);
        uncheck = findViewById(R.id.uncheckall);
        atroll=findViewById(R.id.attroll);
        atstud=findViewById(R.id.attstud);
        btn=findViewById(R.id.submit);
//        db.collection("Student").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                student = new Gson().fromJson(getIntent().getStringExtra("student"), Student.class);
//                for(QueryDocumentSnapshot queryDocumentSnapshot:task.getResult())
//                {
//                    if(task.getResult().size()!=0)
//                    {
//                        student=queryDocumentSnapshot.toObject(Student.class);

//            }}}
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(attendance.this, "Error", Toast.LENGTH_SHORT).show();
//            }
//        });
        Intent i = getIntent();
        String msg = i.getStringExtra("ke1");
        atroll.setText(msg);
        String a=i.getStringExtra("ke2");
        atstud.setText(a);

//        final attendanceadapter attendAdapter = new attendanceadapter(attendance.this,student.students,check,uncheck);
        recyclerView.setAdapter(attendAdapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        String datet=simpleDateFormat.format(new Date());
        date.setText(datet);
//        progressDialog=new ProgressDialog(attendance.this);
        progressDialog.setMessage("Saving Attendance..");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                List<Student> list = attendAdapter.list1;
                String currentdate = date.getText().toString().trim();
                Studentjva student1=new Studentjva();
                student1.setList(list);
                student1.setDate(currentdate);
                db.collection("Data").document(FirebaseAuth.getInstance().getUid())
                        .collection("Attendence")
                        .document(id).collection("attendence")
                        .document(currentdate).set(student1).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            progressDialog.dismiss();
//                            Toast.makeText(attendance.this, "Updated", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
//                        Toast.makeText(attendance.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }}
