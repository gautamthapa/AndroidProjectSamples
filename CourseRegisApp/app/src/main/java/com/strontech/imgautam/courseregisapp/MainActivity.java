package com.strontech.imgautam.courseregisapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2, edt3;
    Button btn1, btn2;
    Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.editText1);
        edt2 = findViewById(R.id.editText2);
        edt3 = findViewById(R.id.editText3);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        spn = findViewById(R.id.spinner1);


        String[] course = getResources().getStringArray(R.array.courseName);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, course);
        spn.setAdapter(adapter);
       /* String name=edt1.getText().toString();
        String email=edt2.getText().toString();
        String number=edt3.getText().toString();
        /*if (name.equals("") && email.equals("") && number.equals("")){
                btn1.setEnabled(false);
        }else {
            btn1.setEnabled(true);
        }*/
        btn1.setOnClickListener(new View.OnClickListener() {


            String name, email, number;

            @Override
            public void onClick(View v) {
                name = edt1.getText().toString();
                email = edt2.getText().toString();
                number = edt3.getText().toString();

                if (name.equals("")) {
                    edt1.setError("Please enter name");

                } else if (email.equals("")) {
                    edt2.setError("Please enter email");

                } else if (!emailValidator(email)) {
                    Toast.makeText(MainActivity.this, "Please enter valid email id", Toast.LENGTH_SHORT).show();

                } else if (number.equals("")) {
                    edt3.setError("Please enter mob. number");

                }else if (isValidateMobile(number)){
                    Toast.makeText(MainActivity.this, "Please enter valid mob number", Toast.LENGTH_SHORT).show();

                }else if (spn.getSelectedItemPosition() == 0) {
                    Toast.makeText(MainActivity.this, "Please select course", Toast.LENGTH_SHORT).show();

                } else {
                    String spnData = spn.getSelectedItem().toString();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("user_name", name);
                    intent.putExtra("email_id", email);
                    intent.putExtra("mob_number", number);
                    intent.putExtra("course", spnData);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("");
                edt2.setText("");
                edt3.setText("");
                if (spn.getSelectedItemPosition() != 0) {
                    spn.setSelection(0);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        edt1.setText("");
        edt2.setText("");
        edt3.setText("");
        if (spn.getSelectedItemPosition() != 0) {
            spn.setSelection(0);
        }
    }


    // For validate the email id
    public static boolean emailValidator(final String mailAddress) {

        Pattern pattern;
        Matcher matcher;

        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(mailAddress);
        return matcher.matches();
    }

   /* private boolean isValidateMobile(String phone){
        return Patterns.PHONE.matcher(phone).matches();
    }*/
   //or
   private boolean isValidateMobile(String phone){
       boolean check=false;
       if (!Pattern.matches("[a-zA-Z]+",phone)) {
           if (phone.length() >= 10 && phone.length() <= 13) {
               check = false;
               //Toast.makeText(this, "Not a valid number", Toast.LENGTH_SHORT).show();
           } else {
               check = true;
           }
       }
       else {
               check=false;
           }
           return check;
       }
   }
