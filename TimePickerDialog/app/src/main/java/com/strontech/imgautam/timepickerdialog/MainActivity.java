package com.strontech.imgautam.timepickerdialog;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = findViewById(R.id.editText);

        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar ca=Calendar.getInstance();
                new TimePickerDialog(MainActivity.this,onTimeSetListener,
                        ca.get(Calendar.HOUR),
                        ca.get(Calendar.MINUTE),
                        true
                ).show();

            }
        });
    }


    //use timePicker dialog
    TimePickerDialog.OnTimeSetListener onTimeSetListener=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            edt.setText(hourOfDay+":"+minute);
        }
    };
}
