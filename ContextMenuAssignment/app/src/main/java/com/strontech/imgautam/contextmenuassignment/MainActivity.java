package com.strontech.imgautam.contextmenuassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    String dt[]={"One","One","One","One","One","One","One"};
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=findViewById(R.id.listView);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dt);
    list.setAdapter(adapter);
        registerForContextMenu(list);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Dut");
        menu.setHeaderIcon(R.drawable.ic_launcher_background);

        menu.add("Rename");
        menu.add("Delete");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle().equals("Rename"))
        {
            Toast.makeText(this, "Rename", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this, "fjdlifjd", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
