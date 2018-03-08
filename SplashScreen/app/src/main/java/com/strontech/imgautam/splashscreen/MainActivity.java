package com.strontech.imgautam.splashscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }

        //we are using splash screen..
        //to handle task.or to delay task...
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               // startActivity(new Intent(MainActivity.this,HomeActivity.class));
           Intent i=new Intent(MainActivity.this,HomeActivity.class);
           startActivity(i);
finish();
            }
        }, 2000);

    }
}
