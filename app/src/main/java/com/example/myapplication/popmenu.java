package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class popmenu extends AppCompatActivity {
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popmenu);
        b=findViewById(R.id.bt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popmenu= new PopupMenu(popmenu.this,b);
                popmenu.getMenuInflater().inflate(R.menu.pop, popmenu.getMenu());
popmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
                {
                  public boolean onMenuItemClick(MenuItem item)
                  {
                      Toast.makeText(popmenu.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                      return true;
                  }

                });
popmenu.show();
            }
        });
    }
}