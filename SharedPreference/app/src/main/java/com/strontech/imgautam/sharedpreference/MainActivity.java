package com.strontech.imgautam.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2;
    Button btn1, btn2, btn3;
    SharedPreferences pref;  //store file reference
    SharedPreferences.Editor  editor;  // to edit data on file

    //give name of file
    private final String FILE ="myfile";   // here UpperCase for Constant in java


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.editText);
        edt2=findViewById(R.id.editText2);
        btn1=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);

        pref=getSharedPreferences(FILE, Context.MODE_PRIVATE);   //if there is file get otherwise create file with mode private

        editor=pref.edit();  // ref of edit file


        // save data button
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nme= edt1.getText().toString().trim();
                String ps= edt2.getText().toString().trim();

                editor.putString("nme_key",nme);
                editor.putString("ps_key",ps);
                editor.commit(); //fot data save;

                Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();

                edt1.setText("");
                edt2.setText("");

            }
        });

        //retrive button
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String nm=pref.getString("nme_key",null); // to stop null pointer exception
                String ps=pref.getString("ps_key",null);

                Toast.makeText(MainActivity.this, ""+nm+"\n"+ps, Toast.LENGTH_SHORT).show();
            }
        });


        //clear data
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.clear();
                editor.commit();

                Toast.makeText(MainActivity.this, "Data erased...7", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
