package com.example.musicplayer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class musicplayer extends AppCompatActivity {

    ImageButton playy,pause,stopp;
    MediaPlayer mediaPlayer;
    boolean isplaying=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playy = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stopp = findViewById(R.id.stop);


        mediaPlayer = MediaPlayer.create(this,R.raw.song);
        playy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isplaying){
                    mediaPlayer.start();
                    isplaying =true;
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isplaying) {
                    mediaPlayer.pause();
                    isplaying = false;
                }
            }
        });

        stopp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                isplaying = false;
            }
        });


        Button btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("audio/*");
                startActivityForResult(intent,10);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && requestCode == 200);{
            MediaPlayer mp = MediaPlayer.create(musicplayer.this,data.getData());
            mp.start();
        }
    }
}