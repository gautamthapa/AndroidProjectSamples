package com.strontech.imgautam.sharedpreferenceslogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LoginFragment loginFragment=new LoginFragment();

        // loginFragment.pref=getSharedPreferences()
        //String FILE=loginFragment.FILE;
        //loginFragment.pref=getSharedPreferences(FILE, Context.MODE_PRIVATE);

        pref=getSharedPreferences("myfile",Context.MODE_PRIVATE);
        editor=pref.edit();
        if (pref.getString("name_key",null)!=null)
        {
            Intent intent=new Intent(MainActivity.this,FirstActivity.class);
            intent.putExtra("key_name",pref.getString("name_key",null));
            startActivity(intent);
        }
            setTheme(android.R.style.Theme_Material_NoActionBar_Fullscreen);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.main_layout, new LoginFragment());
            ft.commit();

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }
}
