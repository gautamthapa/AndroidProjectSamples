package com.strontech.imgautam.menuoptionsmenu;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn.findViewById(R.id.button);

        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    // to make menu override onCreateOptionsMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //to view of menu layout file
        /*MenuInflater inflater=getMenuInflater();
inflater.inflate(R.menu.my_menu,menu);
        */
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // to perform task of item in menu
    // run automatic by parent
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item:
                Toast.makeText(this, "item 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this, "item3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item4:
                startActivity(new Intent(Settings.ACTION_SETTINGS));
                break;
        }
        //Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    //ClickListener
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button:
                Toast.makeText(this, "first button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Toast.makeText(this, "Second button", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void jadu(View view) {
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
    }
}
