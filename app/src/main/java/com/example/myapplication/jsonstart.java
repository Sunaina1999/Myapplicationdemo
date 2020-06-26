package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class jsonstart extends AppCompatActivity {
TextView jt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonstart);
    jt=findViewById(R.id.jt);
    String jstr="{\"Student\":[{\"id\":\"1\",\"name\":\"Aman Saini\",\"marks\":\"50\",\"subject\":\"daa\"},{\"id\":\"2\",\"name\":\"Vikram\",\"marks\":\"80\":\"subject\":\"toc\"}]}";
    String jdata="";
    try {
        JSONObject jsonObject=new JSONObject(jstr);
        JSONArray jsonArray=jsonObject.optJSONArray("Student");
        for(int z=0;z<jsonArray.length();z++)
        {
JSONObject jsonObject1=jsonArray.optJSONObject(z);
       int id=Integer.parseInt(jsonObject1.optString("id").toString());
       String name=jsonObject1.optString("name").toString();
            int marks=Integer.parseInt(jsonObject1.optString("marks").toString());
            String subject=jsonObject1.optString("subject").toString();
       jdata+="record"+z+":\n id="+id+":\n name="+name+":\n marks="+marks+":\n subject="+subject+"\n";
       jt.setText(jdata);
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    }
}