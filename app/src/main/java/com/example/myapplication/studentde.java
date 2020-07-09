package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

public class studentde extends AppCompatActivity {
EditText e1,e2,e3,e4,e5,e6,e7;
Button b1,b2,b3;
    int roll;
    String name;
    String course;
    String mail;
    String cont;
    String userid;
    String dob;
    FirebaseFirestore fb;
    Users1 users1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentde);
        fb=FirebaseFirestore.getInstance();
        e1=findViewById(R.id.dest1);
        e2=findViewById(R.id.dest3);
        e3=findViewById(R.id.dest5);
        e4=findViewById(R.id.dest7);
        e5=findViewById(R.id.dest9);
        e6=findViewById(R.id.dest11);
        e7=findViewById(R.id.dest13);
        b1=findViewById(R.id.bde);
        b2=findViewById(R.id.bde1);
        b3=findViewById(R.id.bde2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll=Integer.parseInt(e1.getText().toString());
                name=e2.getText().toString();
                course=e3.getText().toString();
                mail=e4.getText().toString();
                cont=e5.getText().toString();
                userid=e6.getText().toString();
                dob=e7.getText().toString();
                users1=new Users1( roll,name,course,mail,cont,userid,dob);
                fb.collection("Student").document(name).set(users1).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(studentde.this, "Details Added", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(studentde.this, "Invalid Details", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

             b2.setOnClickListener(new View.OnClickListener() {
        @Override
          public void onClick(View v) {
            roll=Integer.parseInt(e1.getText().toString());
            name=e2.getText().toString();
            course=e3.getText().toString();
            mail=e4.getText().toString();
            cont=e5.getText().toString();
            userid=e6.getText().toString();
            dob=e7.getText().toString();
            fb.collection("Student").document(name).update("roll",roll,"name",name,"course",course,"mail",mail,"contact",cont,"userid",userid,"dob",dob)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(studentde.this, "Data Updated", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(studentde.this, "Failed due to"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
      }
      });
       b3.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         roll=Integer.parseInt(e1.getText().toString());
         name=e2.getText().toString();
         course=e3.getText().toString();
         mail=e4.getText().toString();
         cont=e5.getText().toString();
         userid=e6.getText().toString();
         dob=e7.getText().toString();
         fb.collection("Student").document(name).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
             @Override
             public void onSuccess(Void aVoid) {
                 Toast.makeText(studentde.this, "Data deletd", Toast.LENGTH_SHORT).show();
             }
         }).addOnFailureListener(new OnFailureListener() {
             @Override
             public void onFailure(@NonNull Exception e) {
                 Toast.makeText(studentde.this, "Failed due to"+e.getMessage(), Toast.LENGTH_SHORT).show();
             }
         });
     }
   });
    }
}