package com.example.proyectonavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Splash extends AppCompatActivity {

    private static final long SPLASH_SCREEN_DELAY = 8000;
    //variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo, slogan;
    MediaPlayer reproductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Animación

        //lógica y diseño
        image = findViewById(R.id.imageView);
        logo = findViewById(R.id.textView);
        slogan = findViewById(R.id.textView2);
        //Sonido Intro
        reproductor = MediaPlayer.create(this,R.raw.intro);
        //reproducir en buble reproductor.setLooping(true);
        reproductor.start();

        slogan.setAnimation(bottomAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN_DELAY);

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (reproductor.isPlaying())
        {
            reproductor.stop();
            reproductor.release();
        }
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        reproductor.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        reproductor.pause();
    }
}
