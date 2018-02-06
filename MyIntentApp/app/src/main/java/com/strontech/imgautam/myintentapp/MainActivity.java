package com.strontech.imgautam.myintentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edt, edt2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button1);
        edt=findViewById(R.id.editText1);
        edt2=findViewById(R.id.editText2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nme=edt.getText().toString();
                String phone=edt2.getText().toString();

                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("name_key",nme);
                intent.putExtra("phone_key",phone);
                startActivity(intent);
            }
        });
    }
}
