package com.strontech.imgautam.drapponmentapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edt1, edt2;
    EditText edtD, edtT;
    Button btnPlus, btnMinus, btnSubmit;
    TextView txtCount, txtToken, txtName, txtContact, txtDate, txtTime, txtPerson;
    LinearLayout l1, l2;
    Calendar ca = Calendar.getInstance();

    int count = 1;
    String format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.editText1);
        edt2 = findViewById(R.id.editText2);

        edtD = findViewById(R.id.editTextDate);
        edtT = findViewById(R.id.editTextTime);

        btnPlus = findViewById(R.id.buttonPlus);
        btnMinus = findViewById(R.id.buttonMinus);
        btnSubmit = findViewById(R.id.buttonSubmit);

        txtCount = findViewById(R.id.textCount);

        txtToken = findViewById(R.id.textView1);
        txtName = findViewById(R.id.textView2);
        txtContact = findViewById(R.id.textView3);
        txtDate = findViewById(R.id.textView4);
        txtTime = findViewById(R.id.textView5);
        txtPerson = findViewById(R.id.textView6);


        l1 = findViewById(R.id.main_layout);
        l2 = findViewById(R.id.secondLayout);

        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.INVISIBLE);


        //This editText clickListener and open Date picker
        edtD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(MainActivity.this, dateSetListener,
                        ca.get(Calendar.YEAR),
                        ca.get(Calendar.MONTH),
                        ca.get(Calendar.DAY_OF_MONTH)
                ).show();

            }
        });


        //This editText clickListener and open Date picker
        edtT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new TimePickerDialog(MainActivity.this, timeSetListener,
                        ca.get(Calendar.HOUR),
                        ca.get(Calendar.MINUTE),
                        false
                ).show();
            }
        });


        //To plus the person no
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // This is for counter++ button click upto 10
                txtCount.setText("" + count);
                if (count == 10) {
                    Toast.makeText(MainActivity.this, "Max 10 person", Toast.LENGTH_SHORT).show();
                } else {
                    count++;
                }
            }
        });

        // to minus person no
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // This is for counter-- button click upto 1
                if (count > 1) {
                    count--;
                } else {
                    Toast.makeText(MainActivity.this, "Min 1 person", Toast.LENGTH_SHORT).show();
                }
                txtCount.setText("" + count);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name, contact, date, time, token;

                name = edt1.getText().toString().trim();
                contact = edt2.getText().toString().trim();
                date = edtD.getText().toString().trim();
                time = edtT.getText().toString().trim();


                if (name.equals("")) {
                    edt1.setError("Enter name");
                } else if (contact.equals("")) {
                    edt2.setError("Enter mob number");
                } else if (date.equals("")) {
                    edtD.setError("Please enter date");
                } else if (time.equals("")) {
                    edtT.setError("Please enter time");
                } else {
                    txtName.setText("Name : " + name);
                    txtContact.setText("Contact : " + contact);
                    txtDate.setText("Date : " + date);
                    txtTime.setText("Time : " + time);
                    txtPerson.setText("No. Person : " + txtCount.getText().toString());
                    //To generate token using Random class of java
                    Random random = new Random();
                    txtToken.setText("Token No. :" + random.nextInt(100));


                    l1.setVisibility(View.INVISIBLE);
                    l2.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Your appointment fixed", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            edtD.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

        }
    };

    TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {


            // This is code for AM and PM
            if (hourOfDay == 0) {

                hourOfDay += 12;

                format = "AM";
            } else if (hourOfDay == 12) {

                format = "PM";

            } else if (hourOfDay > 12) {

                hourOfDay -= 12;

                format = "PM";

            } else {

                format = "AM";
            }


            edtT.setText(hourOfDay + ":" + minute + " " + format);
        }
    };


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        edt1.setText("");
        edt2.setText("");
        edtD.setText("");
        edtT.setText("");
        txtCount.setText("");

        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.INVISIBLE);


    }
}
