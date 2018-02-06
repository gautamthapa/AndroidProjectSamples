package com.strontech.imgautam.scrollviewapp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edt1, edt2, edt3, edt4, edt5;
    Button btn;
    Spinner spn1, spn2, spn3;
    RadioButton rb1, rb2;
    String mCourse[], mquali[], mGrad[], mPgrad[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.editText1);
        edt2=findViewById(R.id.editText2);
        edt3=findViewById(R.id.editText3);
        edt4=findViewById(R.id.editText4);
        edt5=findViewById(R.id.editText5);
        btn=findViewById(R.id.button1);
        spn1=findViewById(R.id.spinner1);
        spn2=findViewById(R.id.spinner2);
        spn3=findViewById(R.id.spinner3);
        rb1=findViewById(R.id.radio_button1);
        rb2=findViewById(R.id.radio_button2);

        mCourse=getResources().getStringArray(R.array.course);
        mquali=getResources().getStringArray(R.array.qualification);
        mGrad=getResources().getStringArray(R.array.graduation);
        mPgrad=getResources().getStringArray(R.array.post_gradudation);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mCourse);
        spn1.setAdapter(adapter);

        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mquali);
        spn1.setAdapter(adapter);

        ArrayAdapter<String> adapter3=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mGrad);
        spn1.setAdapter(adapter);

        ArrayAdapter<String> adapte4=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mPgrad);
        spn1.setAdapter(adapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, number, fName, email, address;
                name=edt1.getText().toString();
                number=edt2.getText().toString();
                fName=edt3.getText().toString();
                email=edt1.getText().toString();
                address=edt1.getText().toString();

                if (name.equals("")){
                    edt1.setError("Enter name");
                }else if (number.equals("")){
                    edt2.setError("Enter mob number");
                }else if (fName.equals("")){
                    edt3.setError("Enter your father name");
                }else if (email.equals("")){
                    edt4.setError("Enter email id");
                }else if (address.equals("")){
                    edt5.setError("Enter your address");
                }else {

                    Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("nme",name);
                    intent.putExtra("num",number);
                    intent.putExtra("fther",fName);
                    intent.putExtra("id",email);
                    intent.putExtra("res",address);
                    intent.putExtra("",name);
                    intent.putExtra("",name);
                }

            }
        });
    }
}
