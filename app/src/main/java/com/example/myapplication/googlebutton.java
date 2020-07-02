package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.accounts.AccountManagerFuture;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class googlebutton extends AppCompatActivity {
private SignInButton signInButton;
private GoogleSignInClient googleSignInClient;
private FirebaseAuth auth;
private Button signoutbutton;
private int RC_SIGN_IN=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googlebutton);
        signInButton=findViewById(R.id.gsignin);
        auth=FirebaseAuth.getInstance();
        signoutbutton=findViewById(R.id.gsignout);
        GoogleSignInOptions gso= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
       googleSignInClient= GoogleSignIn.getClient(this,gso);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        signoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleSignInClient.signOut();
                Toast.makeText(googlebutton.this,"You are Logged Out",Toast.LENGTH_SHORT).show();
                signoutbutton.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void signIn() {
        Intent signInIntent=googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN)
        {
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try{
            GoogleSignInAccount ac= completedTask.getResult(ApiException.class);
            Toast.makeText(this, "Sign In Successfully", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(ac);
        }
        catch (ApiException e)
        {
            Toast.makeText(this, "Sign In Failed", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(null);
        }
    }



    private void FirebaseGoogleAuth(GoogleSignInAccount ac) {
        if(ac!=null)
        {
            AuthCredential authCredential= GoogleAuthProvider.getCredential(ac.getIdToken(),null);
            auth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(googlebutton.this, "Successful", Toast.LENGTH_SHORT).show();
                        FirebaseUser user=auth.getCurrentUser();
                        updateUI(user);
                    }
                    else
                    {
                        Toast.makeText(googlebutton.this, "account", Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }
                }
            });
        }
        else
        {
            Toast.makeText(this, "acc failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateUI(FirebaseUser user) {
        signoutbutton.setVisibility(View.VISIBLE);
        GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if(account!=null)
        {
            String personName=account.getDisplayName();
            Toast.makeText(this, personName, Toast.LENGTH_SHORT).show();
        }
    }
}