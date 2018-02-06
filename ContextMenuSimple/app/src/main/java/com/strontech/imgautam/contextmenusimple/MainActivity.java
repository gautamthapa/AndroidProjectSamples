package com.strontech.imgautam.contextmenusimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);

        //here we pass component ref. which you want to perform context menu...
        //implicitly call longpressed
        registerForContextMenu(btn);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Dut");
        menu.setHeaderIcon(R.drawable.ic_launcher_background);

       /* menu.add(0,v.getId(),0,"Android");
        menu.add(0,v.getId(),2,"java");
        menu.add(0,v.getId(),1,"C");
        */

        menu.add("j");
        menu.add("h");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

       // switch (item.getItemId())
//upto jdk 1.7-- switch accept int but after jdk 1.7 switch accept string
      /*  switch (item.getTitle().toString())
        {

        }
        */

        if (item.getTitle().equals("j"))
        {
            Toast.makeText(this, "jokky", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
