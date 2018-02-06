package com.strontech.imgautam.datepickerdialog;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //to get reference of Calender of our phone
                Calendar ca=Calendar.getInstance();

                new DatePickerDialog(MainActivity.this,dateSetListener,
                        ca.get(Calendar.YEAR),
                        ca.get(Calendar.MONTH),
                        ca.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }



    //For Date Picker Dialog
    //mke anonymous object
    DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            editText.setText(dayOfMonth+"/"+(month+1)+"/"+year);
        }
    };

}
