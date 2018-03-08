package com.example.ducat.assigenment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private android.widget.EditText editText;
    private android.widget.EditText editText2;
    private android.widget.Button button;
SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText = (EditText) findViewById(R.id.editText);

        pref=getSharedPreferences("myfile", Context.MODE_PRIVATE);
        editor=pref.edit();

        if(pref.getString("name",null)!=null)
        {
            Intent intent=new Intent(MainActivity.this,WelcomeActivity.class);
            intent.putExtra("name_key",pref.getString("name",null));
            startActivity(intent);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String name=editText.getText().toString();
                String paas=editText2.getText().toString();

                editor.putString("name",name);
                editor.putString("paas",paas);
                editor.commit();

                Intent intent=new Intent(MainActivity.this,WelcomeActivity.class);
                intent.putExtra("name_key",name);
                startActivity(intent);
            }
        });


    }
}
