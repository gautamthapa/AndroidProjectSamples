package com.strontech.imgautam.myintentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txt, txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txt=findViewById(R.id.textView1);
        txt2=findViewById(R.id.textView2);

        // to store data in Bundle
        Bundle b=getIntent().getExtras();

        String n=b.getString("name_key");
        String p=b.getString("phone_key");

        txt.setText("Name "+n);
        txt2.setText("Phone "+p);
    }
}
