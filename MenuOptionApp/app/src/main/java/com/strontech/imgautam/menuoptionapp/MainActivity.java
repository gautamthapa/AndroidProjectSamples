package com.strontech.imgautam.menuoptionapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.main_layout, new MainFragment());
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        switch(id)
        {
            case R.id.item1:

                ft.replace(R.id.main_layout, new LoginFragment());
                ft.addToBackStack("MainActivity");
                ft.commit();
                break;
            case R.id.item2:
                ft.replace(R.id.main_layout, new RegisterFragment());
                ft.addToBackStack("MainActivity");
                ft.commit();
                break;
            case R.id.item3:
                ft.replace(R.id.main_layout, new AboutFragment());
                ft.addToBackStack("MainActivity");
                ft.commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
