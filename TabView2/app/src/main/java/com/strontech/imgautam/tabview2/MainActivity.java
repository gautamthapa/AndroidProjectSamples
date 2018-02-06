package com.strontech.imgautam.tabview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chb1, chb2, chb3, chb4, chb5;
    TabHost tabHost;
    String op1, op2, op3, op4, op5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost = findViewById(R.id.tabHost1);
        chb1 = findViewById(R.id.checkbox1);
        chb2 = findViewById(R.id.checkbox2);
        chb3 = findViewById(R.id.checkbox3);
        chb4 = findViewById(R.id.checkbox4);
        chb5 = findViewById(R.id.checkbox5);

        if (chb1.isChecked()) {
            op1 = chb1.getText().toString();
        } else {
            op1 = "";
        }

        if (chb2.isChecked()) {
            op2 = chb1.getText().toString();
        } else {
            op2 = "";
        }
        if (chb3.isChecked()) {
            op3 = chb1.getText().toString();
        } else {
            op3 = "";
        }
        if (chb4.isChecked()) {
            op4 = chb1.getText().toString();
        } else {
            op4 = "";
        }
        if (chb5.isChecked()) {
            op5 = chb1.getText().toString();
        } else {
            op5 = "";
        }


        tabHost.setup();
       // TabHost.TabSpec tabSpec = tabHost.newTabSpec("Starting tab");

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                TabHost.TabSpec tabSpec = tabHost.newTabSpec("Starting tab");
                int i = tabHost.getCurrentTab();
                if (i == 0) {
                    //first tab
                    tabSpec.setIndicator("PL");
                    tabSpec.setContent(R.id.tab1);
                    tabHost.addTab(tabSpec);
                } else {
                    //second tab'
                    tabSpec = tabHost.newTabSpec("Second Tab");
                    tabSpec.setIndicator("Fav PL");
                    tabSpec.setContent(R.id.tab2);
                    tabHost.addTab(tabSpec);

                }
            }
        });



    }
}
