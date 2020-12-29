package com.example.annie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.os.Handler;

public class SplashActivity extends Activity {


    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this, Login.class);
                startActivity(i);
                finish();
            }
        }, 4000);
    }
}


