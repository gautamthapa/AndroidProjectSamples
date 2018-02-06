package com.example.imgautam.framelayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_layout);

        btn=findViewById(R.id.button1);
        btn=findViewById(R.id.button2);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int i=view.getId();
        if (i==R.id.button1)
        {
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();

    }
}
