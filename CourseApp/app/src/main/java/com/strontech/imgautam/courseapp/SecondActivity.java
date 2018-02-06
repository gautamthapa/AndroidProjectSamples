package com.strontech.imgautam.courseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView txt1, txt2, txt3, txt4, txt5, txt6;
    String gGender, gName, gNumber, gCname, tTeacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txt1=findViewById(R.id.textView1);
        txt2=findViewById(R.id.textView2);
        txt3=findViewById(R.id.textView3);
        txt4=findViewById(R.id.textView4);
        txt5=findViewById(R.id.textView5);
        txt6=findViewById(R.id.textView6);


        Bundle b=getIntent().getExtras();

        gGender=b.getString("gen");
        gName=b.getString("user_name");
        gNumber=b.getString("mob_number");
        gCname=b.getString("course_name");
        tTeacher=b.getString("teacher");

        txt2.setText(String.format("%s %s", gGender, gName));
        txt3.setText("Name: "+gName);
        txt4.setText("Mob. Number: "+gNumber);
        txt5.setText("Course: "+gCname);
        txt6.setText("Trainer: "+tTeacher);

        Toast.makeText(this, "Successfully submitted", Toast.LENGTH_SHORT).show();
    }
}
