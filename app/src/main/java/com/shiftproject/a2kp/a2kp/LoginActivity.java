package com.shiftproject.a2kp.a2kp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.facebook.AccessToken;
public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "LoginActivity";
    public CallbackManager callbackManager;
    public AccessToken facebookAcessToken;
    public FirebaseUser currentUser;
    public FirebaseAuth firebaseAuth;
    public LoginButton loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
        FacebookSdk.setApplicationId("162080441155693");
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
        initializeFacebook();

    }

    protected void onStart() {
        super.onStart();
        currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            //change to new activity
        }

    }

    private void initializeFacebook() {
        // Initialize Facebook Login button
        callbackManager = CallbackManager.Factory.create();
        loginBtn = findViewById(R.id.loginButton);
        loginBtn.setReadPermissions("email", "public_profile");
        loginBtn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                facebookAcessToken = loginResult.getAccessToken();
            }
            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
                // ...
            }
            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
