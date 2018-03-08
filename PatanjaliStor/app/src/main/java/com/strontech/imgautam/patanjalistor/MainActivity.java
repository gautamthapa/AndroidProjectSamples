package com.strontech.imgautam.patanjalistor;


import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }

        pref=getSharedPreferences("myFile",MODE_PRIVATE);

        if (pref.getString("key_mUsername",null) !=null && pref.getString("key_mPass",null) !=null)
        {
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.main_layout, new MerMainFragment());
            ft.commit();
        }else {
            FragmentManager fm1=getSupportFragmentManager();
            FragmentTransaction ft=fm1.beginTransaction();
            ft.replace(R.id.main_layout, new LoginFragment());
            ft.commit();

        }

    }
}
