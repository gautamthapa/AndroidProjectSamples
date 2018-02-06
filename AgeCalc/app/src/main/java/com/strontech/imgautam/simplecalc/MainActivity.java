package com.strontech.imgautam.simplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt1, edt2;
    Button btn1, btn2, btn3, btn4;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.editText1);
        edt2 = findViewById(R.id.editText2);
        btn1 = findViewById(R.id.btn_divide);
        btn2 = findViewById(R.id.btn_multi);
        btn3 = findViewById(R.id.btn_plus);
        btn4 = findViewById(R.id.btn_subtract);
        txt = findViewById(R.id.resultText);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        try {
            String e1 = edt1.getText().toString();
            String e2 = edt1.getText().toString();

            if (e1.equals("")) {
                edt1.setError("Enter any number");
            } else if (e2.equals("")) {
                    edt2.setError("Enter second error");
            } else {
                int i = view.getId();
                //int j=5,k=10;
                double j = Double.parseDouble(edt1.getText().toString());
                double k = Double.parseDouble(edt2.getText().toString());
                // String s1=String.valueOf(Double.parseDouble(edt1.getText().toString()));
                //String s2=String.valueOf(Double.parseDouble(edt2.getText().toString()));

                if (String.valueOf(j).equals("")) {
                    edt1.setError("Please enter number");
                } else if (String.valueOf(k).equals("")) {
                    edt2.setError("Please enter number");
                } else {
                    String res;
                    if (i == R.id.btn_divide) {
                        res = String.valueOf(j / k);
                        txt.setText(res);
                    } else if (i == R.id.btn_multi) {
                        res = String.valueOf(j * k);
                        txt.setText(res);
                    } else if (i == R.id.btn_plus) {
                        res = String.valueOf(j + k);
                        txt.setText(res);
                    } else {
                        res = String.valueOf(j - k);
                        txt.setText(res);
                    }
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }

       /*
*/
    }

}
