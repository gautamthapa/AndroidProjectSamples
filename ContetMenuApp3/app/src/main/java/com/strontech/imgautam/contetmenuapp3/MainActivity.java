package com.strontech.imgautam.contetmenuapp3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int position;
    ListView list;
    ArrayList<String> al=new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=findViewById(R.id.listView);

        al.add("C");
        al.add("C++");
        al.add("Java");
        al.add("Kotlin");
        al.add("Go");
        al.add("HTML");
     adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al);
     list.setAdapter(adapter);
     list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
         @Override
         public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
             MainActivity.this.position=position;
             registerForContextMenu(list);
             return false;
         }
     });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add("Edit");
        menu.add("Remove");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle().equals("Edit"))
        {
            Intent intent=new Intent(this, EditActivity.class);
            intent.putExtra("name_key",al.get(position));
            startActivityForResult(intent,100);

        }else
        {
         al.remove(position);
         adapter.notifyDataSetChanged();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK){
            String s=data.getStringExtra("result");
            Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
            al.set(position,s);
            adapter.notifyDataSetChanged();
        }
    }
}
