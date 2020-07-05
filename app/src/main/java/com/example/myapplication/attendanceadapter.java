package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class attendanceadapter extends RecyclerView.Adapter<attendanceadapter.attendanceViewHolder> {
private String data;
public attendanceadapter(String[] data)
{

}
    @NonNull
    @Override
    public attendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull attendanceViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class attendanceViewHolder extends RecyclerView.ViewHolder
    {

        public attendanceViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    }
