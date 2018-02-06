package com.strontech.imgautam.useofradiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton rb1, rb2, rb3;
    Button btn1;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb1=findViewById(R.id.rd_btn1);
        rb2=findViewById(R.id.rb_btn2);
        rb3=findViewById(R.id.rb_btn3);
        btn1=findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=v.getId();
                if (rb1.isSelected()){

                }
            }
        });
    }
}
