package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.ObjectInputStream;
import java.util.List;

public class attendanceadapter extends RecyclerView.Adapter<attendanceadapter.MyHolder>{
    List<Student> list1;
    CheckBox checkal;
    CheckBox uncheckal;

    public attendanceadapter(attendance attendance, List<Student> list, CheckBox checkall, CheckBox uncheckall) {
        this.list1 = list;
        this.checkal = checkall;
        this.uncheckal = uncheckall;
    }

    @NonNull
    @Override
    public attendanceadapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.attendancelist,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull attendanceadapter.MyHolder myholder, int position) {
        final Student student = list1.get(position);
        myholder.roll.setText(String.valueOf(student.roll));
        myholder.student.setText(String.valueOf(student.name));
        myholder.check.setChecked(student.status);
        checkal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag=true;
                if (flag == true)
                {
                    hideallboxes();
                    flag = false;
                }
            }
        });
        uncheckal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                if (flag == false)
                {
                    showAllBoxes();
                    flag = true;
                }
            }
        });
    }

    private void showAllBoxes() {
        for (Student student : list1) {
            student.setStatus(true);
        }
        notifyDataSetChanged();
    }

    private void hideallboxes() {
        for (Student student : list1)
        {
            student.setStatus(false);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

//    public void add(String name1) {
//     this.list.add(name1);
//    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView roll,student;
        CheckBox check;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            roll=itemView.findViewById(R.id.attroll);
            student=itemView.findViewById(R.id.attstud);
            check=itemView.findViewById(R.id.check);
            check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    list1.get(getAdapterPosition()).setStatus(isChecked);
                }
            });
        }
    }
}
