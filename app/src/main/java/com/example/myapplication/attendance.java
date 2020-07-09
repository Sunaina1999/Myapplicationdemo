package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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

public class attendance extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView date;
    CheckBox uncheck ,check;
    FirebaseAuth auth;
    FirebaseFirestore db;
    Button btn;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        final String id=getIntent().getStringExtra("id");
        final Users1 subject = new Gson().fromJson(getIntent().getStringExtra("list"), Users1.class);
        recyclerView = findViewById(R.id.prv);
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        date = findViewById(R.id.currentdate);
        check = findViewById(R.id.checkall);
        uncheck = findViewById(R.id.uncheckall);
        btn=findViewById(R.id.submit);
        final attendanceadapter attendAdapter = new attendanceadapter(this,subject.list,check,uncheck);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(attendAdapter);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        String datet=simpleDateFormat.format(new Date());
        date.setText(datet);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Saving Attendance..");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
       btn.setOnClickListener(new View.OnClickListener() {
      @Override
       public void onClick(View v) {
          progressDialog.show();
          List<Users1> list = attendAdapter.list;
          String currentdate = date.getText().toString().trim();
          attendance Attendence = new attendance();
          db.collection("Student").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
              @Override
              public void onComplete(@NonNull Task<QuerySnapshot> task) {
                  if(task.isSuccessful())
                  {
                      if(task.getResult().size()!=0)
                      {
                          for(QueryDocumentSnapshot document:task.getResult())
                          {
                              Users1 n=document.toObject(Users1.class);
                              String name1=n.name;
                              attendAdapter.add(name1);
                          }
                      }
                      else
                      {
                          Toast.makeText(attendance.this, "wait", Toast.LENGTH_SHORT).show();
                      }
                  }
              }
          }).addOnFailureListener(new OnFailureListener() {
              @Override
              public void onFailure(@NonNull Exception e) {
                  Toast.makeText(attendance.this, e.getMessage(), Toast.LENGTH_SHORT).show();
              }
          });
          db.collection("Data").document(FirebaseAuth.getInstance().getUid())
                  .collection("Attendence")
                  .document(id).collection("attendence")
                  .document(currentdate).set(Attendence).addOnCompleteListener(new OnCompleteListener<Void>() {
              @Override
              public void onComplete(@NonNull Task<Void> task) {
                  if (task.isSuccessful()) {
                      progressDialog.dismiss();
                      Toast.makeText(attendance.this, "Updated", Toast.LENGTH_SHORT).show();
                      finish();
                  }
              }
          }).addOnFailureListener(new OnFailureListener() {
              @Override
              public void onFailure(@NonNull Exception e) {
                  progressDialog.dismiss();
                  Toast.makeText(attendance.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
              }
          });
    }
});


}}