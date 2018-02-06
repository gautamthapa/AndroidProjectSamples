package com.strontech.imgautam.courseregisapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView textView1, textView2, textView3, textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView1=findViewById(R.id.txt1);
        textView2=findViewById(R.id.txt2);
        textView3=findViewById(R.id.txt3);
        textView4=findViewById(R.id.txt4);

        Bundle b=getIntent().getExtras();

        String name=b.getString("user_name");
        String email=b.getString("email_id");
        String number=b.getString("mob_number");
        String course_name=b.getString("course");

        textView1.setText("Name : "+name);
        textView2.setText("Email : "+email);
        textView3.setText("Mob. Number : "+number);
        textView4.setText("Course : "+course_name);

        Toast.makeText(this, "Successfully submitted", Toast.LENGTH_SHORT).show();
    }
}
