package com.strontech.imgautam.dynamiclistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    EditText edt1;
    Button btn;
    ArrayList<String> al=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=findViewById(R.id.listView);
        edt1=findViewById(R.id.editText1);
        btn=findViewById(R.id.button1);

        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,al);
        list.setAdapter(adapter);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dt=edt1.getText().toString();
                al.add(dt);
                adapter.notifyDataSetChanged(); // for internal refreshing
               // al.remove(0);    to remove element
            }
        });
    }
}
