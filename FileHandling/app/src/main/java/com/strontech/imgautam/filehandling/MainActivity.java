package com.strontech.imgautam.filehandling;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    EditText edt1;

    final private static String FILE_NAME = "myfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        edt1 = findViewById(R.id.editText);


        //save button
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nme = edt1.getText().toString().trim();

                try {

                   // FileOutputStream fout=new FileOutputStream()
                    FileOutputStream fout = openFileOutput(FILE_NAME, Context.MODE_APPEND);
                    //fout=new FileOutputStream(FILE_NAME,true);
                    fout.write(nme.getBytes());
                    fout.close();


//foutt.write(nme.getBytes());
                    //ByteArrayOutputStream
                    Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fin=openFileInput(FILE_NAME);

  int x=0;
  String data="";

  while ((x=fin.read()) !=-1)
  {
      data=data+Character.toString((char) x);
  }
                    Toast.makeText(MainActivity.this, ""+data, Toast.LENGTH_SHORT).show();


                    /*
                    int byteD= fin.read();
                    Toast.makeText(MainActivity.this, ""+(char)byteD, Toast.LENGTH_SHORT).show();
*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
