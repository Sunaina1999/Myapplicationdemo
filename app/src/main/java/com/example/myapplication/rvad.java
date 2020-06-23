package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class rvad extends RecyclerView.Adapter<rvad.vh> {
    private lidata[] lidata1;
    public rvad(lidata[] lidata) {
        this.lidata1 = lidata;
    }


    @NonNull
    @Override
    public vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View lit=layoutInflater.inflate(R.layout.del,parent,false);
        vh viewHolder=new vh(lit);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull rvad.vh holder, int position) {
final lidata lidata= lidata1[position];
holder.tv.setText(lidata1[position].getName());
 holder.iv.setImageResource(lidata1[position].getImgid());
    holder.dv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), ""+ lidata.getName(), Toast.LENGTH_SHORT).show();
        }
    });}

    @Override
    public int getItemCount() {
        return lidata1.length;
    }

    public class vh extends RecyclerView.ViewHolder {
        public ImageView iv;
        public TextView tv;
        public LinearLayout dv;

        public vh(View itemView) {
            super(itemView);
            this.iv=itemView.findViewById(R.id.iv);
            tv=itemView.findViewById(R.id.tv);
            dv=itemView.findViewById(R.id.dv);
        }
    }
}
