package com.strontech.imgautam.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Calendar;

public class ToggleSetEnabled extends AppCompatActivity {

    EditText edt1, edt2, edt3;
    Button btn;
    Calendar calendar;
    TextView txt, txtWel;
    ToggleButton tb1;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_set_enabled);


    }
}
