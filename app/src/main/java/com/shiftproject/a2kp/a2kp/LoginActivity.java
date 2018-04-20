package com.shiftproject.a2kp.a2kp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.CallbackManager;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.facebook.AccessToken;
public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private CallbackManager callbackManager;
    private AccessToken facebookAcessToken;
    private FirebaseUser currentUser;
    private FirebaseAuth firebaseAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

    }

    protected  void onStart(){
        super.onStart();
        currentUser = firebaseAuth.getCurrentUser();
        if(currentUser != null){
            //change to new activity
        }

    }

    private void initializeFacebook(){
        // Initialize Facebook Login button
        callbackManager = CallbackManager.Factory.create();
        //LoginButton loginButton = findViewById(R.id.button_facebook_login);
        //loginButton.setReadPermissions("email", "public_profile");
        //loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
                // ...
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);
                // ...
            }
        });


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            // Pass the activity result back to the Facebook SDK
            CallbackManager.onActivityResult(requestCode, resultCode, data);
        }

    }

}
