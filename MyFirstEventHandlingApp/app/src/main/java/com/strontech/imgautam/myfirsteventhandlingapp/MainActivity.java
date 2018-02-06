package com.strontech.imgautam.myfirsteventhandlingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.editText1);
        edt2 = findViewById(R.id.editText2);
        btn = findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nme = edt1.getText().toString();
                String pss = edt2.getText().toString();

                if (nme.equals("")) {
                    edt1.setError("Enter your user name");
                } else if (pss.equals("")) {
                    edt2.setError("Enter your password");
                } else if(nme.equals("Ducat")&&pss.equals("Jadu")){
                    Toast.makeText(MainActivity.this, "Welcome in Ducat " , Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid user ", Toast.LENGTH_SHORT).show();
                    edt1.setText("");
                    edt2.setText("");
                    edt1.setFocusable(true);
                }
            }
        });
    }
}
