package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.SearchEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class call extends AppCompatActivity {

    private static final int REQUEST_CALL_PHONE = 1;
    private static final int REQUEST_INTERNET = 2;
    private static final int REQUEST_SEND_SMS =3;
    EditText edtmobile,edtsms,edtmail,edtsearch;
    Button btncall,btnsms,btnmail,btnsearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        edtmobile=findViewById(R.id.edt_mob);
        edtsms=findViewById(R.id.edt_text);
        edtmail=findViewById(R.id.edt_mail);
        edtsearch=findViewById(R.id.edt_web);
        btncall=(Button)findViewById(R.id.btn_call);
        btnsms=findViewById(R.id.btn_sms);
        btnmail=findViewById(R.id.btn_mail);
        btnsearch=findViewById(R.id.btn_search);
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phonecall();
            }

        });
        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForSmsPermission();
                try {
//              Intent i=new Intent(Intent.ACTION_VIEW);i.setData(Uri.parse("smsto:"));
//              i.setType("vnd.android-dir/mms-sms");
//              i.putExtra("address",new String(edtmobile.getText().toString()));
//               i.putExtra("sms_body",edtsms.getText().toString());
//               startActivity(Intent.createChooser(i,"Send sms via:"));
            }
                catch(Exception e)
                {
                 //Toast.makeText(call.this,"SMS Failed to Send Please Try Again",Toast.LENGTH_SHORT).show();
                }
            }

            });
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchweb();
            }
        });

    }
    private void phonecall() {
if (ContextCompat.checkSelfPermission(call.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(call.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL_PHONE);
        }
else
    {
        String name= (edtmobile.getText()).toString();
        Intent i=new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:"+name));
        startActivity(i);
}
    }
    private void searchweb()
    {
        if (ContextCompat.checkSelfPermission(call.this, Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(call.this, new String[]{Manifest.permission.INTERNET}, REQUEST_INTERNET);
        }
        else
        {
            String a=(edtsearch.getText()).toString();
            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://"+a));
            startActivity(i);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        {if(requestCode==REQUEST_CALL_PHONE)
        {
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                phonecall();
        }
    }
        else
        {
            Toast.makeText(call.this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }}
        {if(requestCode==REQUEST_INTERNET)
        {
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                searchweb();
            }
        }
        else
        {
            Toast.makeText(call.this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }}
}
        private void checkForSmsPermission() {
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},REQUEST_SEND_SMS);
        }
        else
        {
            enableSmsButton();
        }
    }

    private void enableSmsButton() {
        try {
                SmsManager smgr=SmsManager.getDefault();
                smgr.sendTextMessage(edtmobile.getText().toString(),null,edtsms.getText().toString(),null,null);
                Toast.makeText(getApplicationContext(), "SMS SENT SUCCESSFULLY", Toast.LENGTH_SHORT).show();
            }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "SMS FAILED TO SEND", Toast.LENGTH_SHORT).show();
        }
    }
    public void onRequestPermissionResult(int requestcode,@NonNull String[]permission,@NonNull int[] grantResults)
    {
        switch (requestcode)
        {
            case REQUEST_SEND_SMS:
            {
                if(permission[0].equalsIgnoreCase(Manifest.permission.SEND_SMS)&& grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    enableSmsButton();
                }
                else
                {
                    Toast.makeText(this, "Sorry", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}