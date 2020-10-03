package com.example.trackmygoods.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.example.trackmygoods.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moveAnim();
    }

    public void moveAnim(){
        TextView diagview = (TextView)findViewById(R.id.diagID);

        TranslateAnimation animation =new TranslateAnimation(0.0f,0.0f,0.0f,-400.0f);
        animation.setDuration(1500);
        animation.setRepeatCount(0);
        animation.setFillAfter(true);
        diagview.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },1000);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
