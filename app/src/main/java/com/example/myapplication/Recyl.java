package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Recyl extends AppCompatActivity {
RecyclerView rv;
FirebaseFirestore firebaseFirestore;
//FirestoreRecycler adapter;
//Helpadapter helpadapter;
//DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyl);
        rv = findViewById(R.id.recylr);
        firebaseFirestore = FirebaseFirestore.getInstance();
        Query query = firebaseFirestore.collection("Student");
//        FirestoreRecyclerOptions<Users1> options = new FirestoreRecyclerOptions.Builder<Users1>().setQuery(query, Users1.class).build();
//        adapter = new FirestoreRecyclerAdapter<Users1, ProductViewHolder>(options) {

//       rv.setAdapter(helpadapter);
//       users1s=new ArrayList<>();
//       databaseReference= FirebaseDatabase.getInstance().getReference("Student");
//       databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
//           @Override
//           public void onDataChange(@NonNull DataSnapshot snapshot) {
//               for(DataSnapshot ds:snapshot.getChildren() )
//               {
//                   Users1 data=ds.getValue(Users1.class);
//                   users1s.add(data);
//               }
//               helpadapter=new Helpadapter(users1s);
//               rv.setAdapter(helpadapter);
//           }
//
//           @Override
//           public void onCancelled(@NonNull DatabaseError error) {
//
//           }
//       });

//            @NonNull
//
//            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout, parent, false);
//                return new ProductViewHolder(view);
//            }
//
//            public void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull Users1 model) {
//                holder.name.setText(model.getName());
//                holder.userid.setText(model.getUserid());
//
//            }
//        };
//        rv.setLayoutManager(new LinearLayoutManager(this));
//        rv.setAdapter(adapter);
//    }
//    class ProductViewHolder extends RecyclerView.ViewHolder{
//        TextView name,userid;
//        public ProductViewHolder(@NonNull View itemView) {
//            super(itemView);
//            name=itemView.findViewById(R.id.name);
//            userid=itemView.findViewById(R.id.user);
//
//        }


    }}