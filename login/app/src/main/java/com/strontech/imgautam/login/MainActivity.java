package com.strontech.imgautam.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn, btn2;
    EditText editText, editText2;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button);
        //btn=findViewById(R.id.button2);

        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
pref=getSharedPreferences("myfile",MODE_PRIVATE);
editor=pref.edit();

if (pref.getString("n"))
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nme=editText.getText().toString();
                String ps=editText.getText().toString();

                editor.putString("nme_key",nme);
                editor.putString("ps_key",ps);
                editor.commit();

                Intent intent=new Intent(MainActivity.this,welcome.class);

            }
        });
    }
}
