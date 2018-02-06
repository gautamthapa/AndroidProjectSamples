package com.strontech.imgautam.dynamiclistapp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edt1, edt2, edt3;
    Button btn, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.main_layout,new FirstFragment());
        ft.commit();

       /* edt1=findViewById(R.id.editText1);
        edt2=findViewById(R.id.editText2);
        edt3=findViewById(R.id.editText3);

        btn=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);




    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name=edt1.getText().toString();
            String roll=edt1.getText().toString();
            String clas=edt1.getText().toString();

            //SecondActivity s=new SecondActivity();


            Intent intent=new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("sName",name);
            intent.putExtra("sRoll",roll);
            intent.putExtra("sClas",clas);
            startActivity(intent);
        }
    });

    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i =new Intent(MainActivity.this, SecondActivity.class);
            startActivity(i);
        }
    });*/
    }
}
