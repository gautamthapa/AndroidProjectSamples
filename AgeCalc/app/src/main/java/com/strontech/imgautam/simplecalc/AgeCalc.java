package com.strontech.imgautam.simplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
public class AgeCalc extends AppCompatActivity {

    EditText edt1, edt2, edt3;
    Button btn;
    Calendar calendar;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calc);

        edt1 = findViewById(R.id.enter_day);
        edt2 = findViewById(R.id.enter_month);
        edt3 = findViewById(R.id.enter_year);
        btn = findViewById(R.id.age_calc);
        txt = findViewById(R.id.result);

        calendar = Calendar.getInstance();
        //calendar=Calendar.MONTH;
        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //int mDay=calendar.get(Calendar.DAY_OF_MONTH);
                //String str=String.valueOf(mDay);
                //Toast.makeText(AgeCalc.this, str, Toast.LENGTH_SHORT).show();
                try {
                    String str1=edt1.getText().toString();
                    String str2 = edt2.getText().toString();
                    String str3= edt3.getText().toString();

                    int calcDay, calcMonth, calcYear;
                    int cDay = calendar.get(Calendar.DAY_OF_MONTH);
                    int cMonth = calendar.get(Calendar.MONTH);
                    int cYear = calendar.get(Calendar.YEAR);

                    int bDay = Integer.parseInt(edt1.getText().toString());
                    int bMonth = Integer.parseInt(edt2.getText().toString());
                    int bYear = Integer.parseInt(edt3.getText().toString());
                    if (str1.equals("")){
                        edt1.setError("please enter your day of birth !");
                    }else if (bDay > 31 && bDay < 1) {
                        edt1.setError("please enter valid day");
                    } else if (str2.equals("")){
                        edt2.setError("please enter your month of birth !");
                    }else if (bMonth > 12 && bMonth < 1) {
                        edt2.setError("please enter valid month");
                    }
                    else if (str3.equals("")){
                        edt3.setError("please enter your year of birth !");
                    } else if (bYear > cYear && bYear > 1900) {
                        edt3.setError("please enter valid year");
                    }
                    else {
                        if (bDay > cDay) {
                            cMonth = cMonth - 1;
                            cDay = cDay + 30;
                        }
                        if (bMonth > cMonth) {
                            cYear = cYear - 1;
                            cMonth = cMonth + 12;
                        }
                        if (bYear > cYear) {
                            edt3.setError("please enter your year of birth !");
                            //exit(0);
                        }
                        calcDay = cDay - bDay;
                        calcMonth = cMonth - bMonth;
                        calcYear = cYear - bYear;
                        String ccDay = String.valueOf(calcDay);
                        String ccMonth = String.valueOf(calcMonth);
                        String ccYear = String.valueOf(calcYear);
                        txt.setText(ccYear + " years " + ccMonth + " months " + ccDay + " days");
                    }
                } catch (Exception e) {
                    e.printStackTrace();

                    //edt1.setError("E");
                    Toast.makeText(AgeCalc.this, "please enter valid number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
