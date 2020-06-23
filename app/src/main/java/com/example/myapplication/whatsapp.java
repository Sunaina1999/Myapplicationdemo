package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class whatsapp extends AppCompatActivity {
EditText e1,e2;
TextView txt;
CountryCodePicker cccodepicker;
Button btnSendMessage;
String strMessage, strMobileNumber="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);
        btnSendMessage=findViewById(R.id.send);
        e1=findViewById(R.id.MOBILE);
        e2=findViewById(R.id.msg);
        txt=findViewById(R.id.text);
        cccodepicker=findViewById(R.id.ccode);
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strMobileNumber=e1.getText().toString();
                strMessage=e2.getText().toString();
                if(e1.getText().toString().isEmpty()&& e2.getText().toString().isEmpty())
                {
                    Toast.makeText(whatsapp.this, "Enter mobile number and message you want to send", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    cccodepicker.registerCarrierNumberEditText(e1);
                    strMobileNumber=cccodepicker.getFullNumber();
                    boolean installed=appInstalledorNot("com.whatsapp");
                    if(installed)
                    {
                        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone="+strMobileNumber+"&text="+strMessage));
                        startActivity(intent);
                        e1.setText("");
                        e2.setText("");
                    }
                    else
                    {
                        Toast.makeText(whatsapp.this, "Whatsapp not installed on your device", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    private boolean appInstalledorNot(String uri) {
        PackageManager packageManager=getPackageManager();
        boolean appInstalled;
        try {
            packageManager.getPackageInfo(uri,PackageManager.GET_ACTIVITIES);
            appInstalled=true;
        }
        catch (PackageManager.NameNotFoundException e) {
            appInstalled=false;
        }
        return appInstalled;
    }}
