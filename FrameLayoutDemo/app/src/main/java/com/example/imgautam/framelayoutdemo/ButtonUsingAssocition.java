package com.example.imgautam.framelayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonUsingAssocition extends AppCompatActivity {

    Button btn, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_using_assocition);

        btn=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);
        // This is anonymous inner class
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ButtonUsingAssocition.this, "hello", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
