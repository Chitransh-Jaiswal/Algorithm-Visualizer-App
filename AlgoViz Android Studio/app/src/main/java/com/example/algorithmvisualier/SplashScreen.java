package com.example.algorithmvisualier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    ImageView iv;
    Handler h = new Handler();
    TextView tvv;
    LottieAnimationView lav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();
//        iv = (ImageView) findViewById(R.id.imageView);
        tvv = (TextView) findViewById(R.id.appname);
        lav = (LottieAnimationView) findViewById(R.id.logoAnimation);

        tvv.animate().translationY(-1400).setDuration(2700).setStartDelay(0);

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, HomePage.class);
                startActivity(i);
                finish();
            }
        }, 5000);

    }
}