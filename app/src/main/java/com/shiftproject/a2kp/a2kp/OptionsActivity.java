package com.shiftproject.a2kp.a2kp;
import android.util.Log;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class OptionsActivity extends AppCompatActivity {
    public FirebaseUser currentUser;
    public static final String TAG = "OptionsActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        final MediaPlayer song=MediaPlayer.create(OptionsActivity.this,R.raw.music);
        if(song!= null)
        {
            song.setLooping(true);
            song.setVolume(100,100);


        }
        //if (!song.isPlaying())
        //song.start();
        //mAuth = FirebaseAuth.getInstance();
        //FirebaseUser currentUser = mAuth.getCurrentUser();
        final SwitchCompat toggle = (SwitchCompat)findViewById(R.id.switch1);
        if (toggle==null)
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if(!song.isPlaying())
                        song.start();

                } else {
                    if(song.isPlaying())
                        song.pause();
                }
            }
        });
    }
}