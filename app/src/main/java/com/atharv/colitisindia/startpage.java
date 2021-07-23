package com.atharv.colitisindia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class startpage extends AppCompatActivity {
   ImageView imageView6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);
        Animation animations;
        animations = AnimationUtils.loadAnimation(this , R.anim.animations);
        imageView6 = findViewById(R.id.imageView6);




        imageView6.setAnimation(animations);


        Handler animationsstart = new Handler();
        animationsstart.postDelayed(new Runnable() {
            @Override
            public void run() {



                startActivity(new Intent(startpage.this , MainActivity.class));
            }
        }, 3000);


    }
}

