package com.strontech.imgautam.fragmentdatatransfer;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm=getSupportFragmentManager();
       // android.support.v4.app.FragmentManager we use this package

        FragmentTransaction ft=fm.beginTransaction();
    ft.replace(R.id.min_layout, new FirstFragment());
    ft.commit();
    }
}
