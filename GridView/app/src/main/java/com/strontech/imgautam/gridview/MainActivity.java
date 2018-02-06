package com.strontech.imgautam.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    /*String[] dt={"java", "C", "C++", "Python"};*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridView1);

        /*ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dt);
        gridView.setAdapter(adapter);*/
        gridView.setAdapter(new MyCustomAdapter(this));
    }
}
