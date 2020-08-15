package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class studentde extends AppCompatActivity {
EditText e1,e2,e3,e4,e5,e6,e7;
Button b1,b2,b3,b4;
    String roll;
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
        b4=findViewById(R.id.bde3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll=e1.getText().toString();
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
        Intent i=new Intent(getApplicationContext(),attendance.class);
        i.putExtra("ke1",roll);
        i.putExtra("ke2",name);
        startActivity(i);
             b2.setOnClickListener(new View.OnClickListener() {
        @Override
          public void onClick(View v) {
            roll=e1.getText().toString();
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
         roll=e1.getText().toString();
         name=e2.getText().toString();
         course=e3.getText().toString();
         mail=e4.getText().toString();
         cont=e5.getText().toString();
         userid=e6.getText().toString();
         dob=e7.getText().toString();
         fb.collection("Student").document(name).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
             @Override
             public void onSuccess(Void aVoid) {
                 Toast.makeText(studentde.this, "Data deleted", Toast.LENGTH_SHORT).show();
             }
         }).addOnFailureListener(new OnFailureListener() {
             @Override
             public void onFailure(@NonNull Exception e) {
                 Toast.makeText(studentde.this, "Failed due to"+e.getMessage(), Toast.LENGTH_SHORT).show();
             }
         });
     }
   });
      b4.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
final String roll1= e1.getText().toString();
fb.collection("Student").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if(task.isSuccessful())
        {
            for(QueryDocumentSnapshot queryDocumentSnapshot:task.getResult())
            {
                if(task.getResult().size()!=0)
                {
                    users1=queryDocumentSnapshot.toObject(Users1.class);
                    String fbuserroll= users1.getRoll();
                    String fbname=users1.getName();
                    String fbcourse=users1.getCourse();
                    String fbmail=users1.getMail();
                    String fbcont=users1.getCont();
                    String fbuserid=users1.getUserid();
                    String fbdob=users1.getDob();
//                                    Toast.makeText(first.this, ""+fbusername, Toast.LENGTH_SHORT).show();
                    if(fbuserroll.equals(roll1))
                    {
                     e2.setText(fbname);
                     e3.setText(fbcourse);
                     e4.setText(fbmail);
                     e5.setText(fbcont);
                     e6.setText(fbuserid);
                     e7.setText(fbdob);
                    }

                }
                    else
                    {
                        Toast.makeText(studentde.this, "Details are invalid", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    }
}).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception e) {
        Toast.makeText(studentde.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}); }
      });
    }
}
// db.collection("Student").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//              @Override
//              public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                  if(task.isSuccessful())
//                  {
//                      if(task.getResult().size()!=0)
//                      {
//                          for(QueryDocumentSnapshot document:task.getResult())
//                          {
//                              Users1 n=document.toObject(Users1.class);
//                              String name1=n.name;
//                              attendAdapter.add(name1);
//                          }
//                      }
//                      else
//                      {
//                          Toast.makeText(attendance.this, "wait", Toast.LENGTH_SHORT).show();
//                      }
//                  }
//              }
//          }).addOnFailureListener(new OnFailureListener() {
//              @Override
//              public void onFailure(@NonNull Exception e) {
//                  Toast.makeText(attendance.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//              }
//          });