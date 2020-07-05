package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class AfterLoginingoogle extends AppCompatActivity {
    TextView name,email;
//    ImageView userimage;
    Button logout;
    GoogleSignInClient googleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_loginingoogle);

//        name=findViewById(R.id.google_name);
//        email=findViewById(R.id.google_email);
//        userimage=findViewById(R.id.google_image);
        logout=findViewById(R.id.signoutgoogle);

        GoogleSignInOptions gs=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();

        googleSignInClient= GoogleSignIn.getClient(this,gs);
        GoogleSignInAccount signInAccount=GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount!=null)
        {
            String gname=signInAccount.getDisplayName();
            String gemail=signInAccount.getEmail();
            Toast.makeText(this, gname, Toast.LENGTH_SHORT).show();
//            Uri uri=signInAccount.getPhotoUrl();

//            name.setText(gname);
//            email.setText(gemail);
//            Glide.with(this).load(uri).into(userimage);
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleSignInClient.signOut();
                Toast.makeText(AfterLoginingoogle.this, "Successfull", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),googlesignin.class));
                finish();
            }
        });
    }

}
