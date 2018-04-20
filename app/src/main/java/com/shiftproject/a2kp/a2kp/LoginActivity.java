package com.shiftproject.a2kp.a2kp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_login);
    }
}
