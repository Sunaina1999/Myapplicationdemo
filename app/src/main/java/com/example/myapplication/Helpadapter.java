package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Helpadapter extends RecyclerView.Adapter {
    List<Users1> users1s;

    public Helpadapter(List<Users1> users1s) {
        this.users1s = users1s;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout,parent,false);
        ViewHolderClass viewHolderClass=new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass viewHolderClass=(ViewHolderClass)holder;
        Users1 users1=users1s.get(position);
        viewHolderClass.name.setText(users1.getName());
        viewHolderClass.userid.setText(users1.getUserid());

    }

    @Override
    public int getItemCount() {
        return users1s.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder
    {
        TextView name,userid;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            userid=itemView.findViewById(R.id.user);
        }
    }
}
