package com.zodiacsign.onin.zodiacsign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash_screen extends AppCompatActivity {
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        iv = (ImageView)findViewById(R.id.zodiac_banner);
        Animation myAnim = AnimationUtils.loadAnimation(this,R.anim.mytransistion);
        iv.startAnimation(myAnim);
        final Intent intent = new Intent (this,MainActivity.class);
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        t.start();
    }
}
