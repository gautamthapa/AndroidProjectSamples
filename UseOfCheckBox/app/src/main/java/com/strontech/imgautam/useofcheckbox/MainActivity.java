package com.strontech.imgautam.useofcheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chbx1, chbx2, chbx3, chbx4;
    Button btn1;
    String op1, op2, op3, op4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chbx1 = findViewById(R.id.checkBox1);
        chbx2 = findViewById(R.id.checkBox2);
        chbx3 = findViewById(R.id.checkBox3);
        chbx4 = findViewById(R.id.checkBox4);
        btn1 = findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!chbx1.isChecked() && !chbx2.isChecked() && !chbx3.isChecked() && !chbx4.isChecked()) {
                    Toast.makeText(MainActivity.this, "Please select any item", Toast.LENGTH_SHORT).show();
                } else {
                    if (chbx1.isChecked()) {
                        op1 = chbx1.getText().toString();
                    } else {
                        op1 = "";
                    }

                    if (chbx2.isChecked()) {
                        op2 = chbx2.getText().toString();
                    } else {
                        op2 = "";
                    }
                    if (chbx3.isChecked()) {
                        op3 = chbx3.getText().toString();
                    } else {
                        op3 = "";
                    }
                    if (chbx4.isChecked()) {
                        op4 = chbx4.getText().toString();
                    } else {
                        op4 = "";
                    }
                    Toast.makeText(MainActivity.this, "" + op1 + "" + op2 + "" + op3 + "" + op4 + " is selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
