package com.strontech.imgautam.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    btn=findViewById(R.id.button);
    btn2=findViewById(R.id.button2);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i=new Intent(MainActivity.this,MyService.class);
            startService(i);

        }
    });

    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i=new Intent(MainActivity.this,MyService.class);
            stopService(i);

        }
    });
    }
}
