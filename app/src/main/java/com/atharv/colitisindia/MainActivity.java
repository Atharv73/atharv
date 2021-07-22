package com.atharv.colitisindia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
   TextView textView4,textView6,textView8;
   Button button3;
   ImageView imageView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        textView4 = findViewById(R.id.textView4);
        textView6 = findViewById(R.id.textView6);
        imageView3 = findViewById(R.id.imageView3);
        textView8 = findViewById(R.id.textView8);


      Animation animations,bottomanimations;


        button3 = findViewById(R.id.button3);

        animations = AnimationUtils.loadAnimation(this , R.anim.animations);
        bottomanimations = AnimationUtils.loadAnimation(this , R.anim.bottomanimations);

        imageView3.setAnimation(animations);
        textView6.setAnimation(bottomanimations);
        textView4.setAnimation(bottomanimations);
        textView8.setAnimation(bottomanimations);




        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, login2pg.class));



            }
        });

        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("http://www.colitisassociationindia.com/");



            }

            private void gotoUrl(String s) {

                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));

            }
        });

















}
}