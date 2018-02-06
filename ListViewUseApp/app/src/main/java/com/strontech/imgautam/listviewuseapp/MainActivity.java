package com.strontech.imgautam.listviewuseapp;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list1;
    ConstraintLayout c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c=findViewById(R.id.main_layout);
        list1=findViewById(R.id.listView2);



        //Start first fragment
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.main_layout, new FirstFragment());
        ft.commit();


        String data[]=getResources().getStringArray(R.array.hindi_writers);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        list1.setAdapter(adapter);

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    c.setVisibility(View.GONE);
                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.main_layout, new FirstFragment());
                    ft.addToBackStack("Main Activity");
                    ft.commit();
                }else{
                    c.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, " Sorry Data unavailable", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
