package com.strontech.imgautam.bottomnavigationbar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    FragmentManager fm;
    FragmentTransaction ft;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.container, new FirstFragment());
                    ft.commit();
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    FragmentManager fm1=getSupportFragmentManager();
                    FragmentTransaction ft1=fm1.beginTransaction();
                    ft1.replace(R.id.container, new SecondFragment());
                    ft1.commit();
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    FragmentManager fm2=getSupportFragmentManager();
                    FragmentTransaction ft2=fm2.beginTransaction();
                    ft2.replace(R.id.container, new ThirdFragment());
                    ft2.commit();
                    return true;
                case R.id.navigation_download:
                    FragmentManager fm3=getSupportFragmentManager();
                    FragmentTransaction ft3=fm3.beginTransaction();
                    ft3.replace(R.id.container, new ThirdFragment());
                    ft3.commit();
                    return true;
                case R.id.navigation_camera:
                    FragmentManager fm4=getSupportFragmentManager();
                    FragmentTransaction ft4=fm4.beginTransaction();
                    ft4.replace(R.id.container, new ThirdFragment());
                    ft4.commit();
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();
        ft.replace(R.id.container, new FirstFragment());
        ft.commit();
    }

}
