package com.strontech.imgautam.patanjalistorenew.activities;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.strontech.imgautam.patanjalistorenew.R;
import com.strontech.imgautam.patanjalistorenew.fragments.LoginFragment;
import com.strontech.imgautam.patanjalistorenew.sql.UserDatabaseHelper;

public class FirstActivity extends AppCompatActivity {

    private UserDatabaseHelper userDatabaseHelper;

    private String getEmailFromPref, getGetPassFromPref;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }


    }
}
