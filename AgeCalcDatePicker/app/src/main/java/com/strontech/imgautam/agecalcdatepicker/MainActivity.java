package com.strontech.imgautam.agecalcdatepicker;

import android.app.DatePickerDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    TextView txt, txt2;
    String age;
    DatePickerDialog.OnDateSetListener onDateSetListener;

    int year, month, dayOfMonth;
    Calendar ca=Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt=findViewById(R.id.editText);
        txt=findViewById(R.id.textView);
        txt2=findViewById(R.id.textView2);

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                MainActivity.this.year=year;
                MainActivity.this.month=month;
                MainActivity.this.dayOfMonth=dayOfMonth;
                edt.setText(dayOfMonth+"/"+(month+1)+"/"+year);

                txt2.setText("You are");
                txt.setText(String.format("%s", getAge(year, month, dayOfMonth)));
            }
        };

        //this is to hide keyboard
        edt.setInputType(InputType.TYPE_NULL);


        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this,onDateSetListener,
                        ca.get(Calendar.YEAR),
                        ca.get(Calendar.MONTH),
                        ca.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }

    String getAge(Integer year, Integer month, Integer day) {

        int calcDay, calcMonth, calcYear;
        int cDay = ca.get(Calendar.DAY_OF_MONTH);
        int cMonth = ca.get(Calendar.MONTH);
        int cYear = ca.get(Calendar.YEAR);
        if (day > cDay) {
            cMonth = cMonth - 1;
            cDay = cDay + 30;
        }
        if (month > cMonth) {
            cYear = cYear - 1;
            cMonth = cMonth + 12;
        }
        if (month > cYear) {
            edt.setError("please enter your year of birth !");
            //exit(0);
        }
        if (year >= cYear && year > 1900)
        {
            edt.setError("Enter valid date of birth");
        }
        calcDay = cDay - day;
        calcMonth = cMonth - month;
        calcYear = cYear - year;
        String ccDay = String.valueOf(calcDay);
        String ccMonth = String.valueOf(calcMonth);
        String ccYear = String.valueOf(calcYear);
         age=ccYear+" Year "+ccMonth+" Month "+ccDay+" Days ";
        return age;
    }
}
