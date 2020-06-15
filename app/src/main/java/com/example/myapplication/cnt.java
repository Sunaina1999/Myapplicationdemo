package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class cnt extends AppCompatActivity {
ListView lv;
String cont[]={"Aman","Amandeep","Devang","Sunaina"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnt);
        lv=findViewById(R.id.clv);
        final ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cont);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.cntmenu,menu);
        menu.setHeaderIcon(R.drawable.call);
        menu.setHeaderIcon(R.drawable.sms);
        menu.setHeaderTitle("contact via");
    }

//    public void onCreateContextMenu(ContextMenu menu, View v, Context context)
//    {
//        super.onCreateContextMenu(menu ,v, (ContextMenu.ContextMenuInfo) context);
//        getMenuInflater().inflate(R.menu.cntmenu,menu);
//        menu.setHeaderIcon(R.drawable.call);
//        menu.setHeaderTitle("contact via");
//    }

    public boolean onContextItemSelected(MenuItem item)
    {
        if(item.getItemId()== R.id.call)
        {
            Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.sms)
        {
            Toast.makeText(this, "SMS", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Nothing", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}