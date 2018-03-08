package com.strontech.imgautam.databasetest;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_layout, new SignupFragment());
       // ft.addToBackStack("main");
        ft.commit();

    }
}
