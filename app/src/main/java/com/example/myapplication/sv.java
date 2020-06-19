package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class sv extends AppCompatActivity {
ListView slv;
ArrayList<String> mylist;
ArrayAdapter<String> ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sv);
        slv= findViewById(R.id.slv);
        mylist=new ArrayList<>();
        mylist.add("apple");
        mylist.add("apricot");
        mylist.add("avacado");
        mylist.add("banana");
        mylist.add("mango");
        ad=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mylist);
    slv.setAdapter(ad);}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.svmenu,menu);
        MenuItem searchviewItem= menu.findItem(R.id.search_bar); //get id from svmenu
        SearchView searchView= (SearchView) MenuItemCompat.getActionView(searchviewItem); // creating view
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
               if(mylist.contains(query))
               {
                   ad.getFilter().filter(query);
               }
               else
               {
                   Toast.makeText(sv.this, "no such thing found", Toast.LENGTH_SHORT).show();
               }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ad.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}