package com.strontech.imgautam.useoffragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment ff=new FirstFragment();
        android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.main_layout, ff);
        ft.commit();

      //FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        //ft.replace(R.id.main_layout, ff);
        //ft.commit();
    }
}
