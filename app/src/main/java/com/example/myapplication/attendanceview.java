package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class attendanceview extends AppCompatActivity {
EditText e1;
Button b1;
FirebaseFirestore f;
Users1 user1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendanceview);
        e1=findViewById(R.id.dateview);
        b1=findViewById(R.id.okview);
        final String date=e1.getText().toString();
f.collection("Attendance").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if(task.isSuccessful())
        {
            for(QueryDocumentSnapshot queryDocumentSnapshot:task.getResult())
            {
                if(task.getResult().size()!=0)
                {
                    user1=queryDocumentSnapshot.toObject(Users1.class);
                    String fbdate=user1.getDate();
                    if(fbdate.equals(date))
                    {

                    }
                    else
                    {
                        Toast.makeText(attendanceview.this, "Invalid date entered", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
        else
        {
            Toast.makeText(attendanceview.this, "Task is not successful", Toast.LENGTH_SHORT).show();
        }
    }
}).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception e) {
        Toast.makeText(attendanceview.this, "Failed due to"+e.getMessage(), Toast.LENGTH_SHORT).show();
    }
});
    }
}