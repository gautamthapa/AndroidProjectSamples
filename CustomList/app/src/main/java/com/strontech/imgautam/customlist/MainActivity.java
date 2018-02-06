package com.strontech.imgautam.customlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // add images in array
    public Integer picture[] =
            {
                    R.drawable.del,
                    R.drawable.hyd,
                    R.drawable.pune
            };
    public String dt[];
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dt = getResources().getStringArray(R.array.city);   //get string array from string.xml file
        list = findViewById(R.id.listView1);

        MyCustomAdapter myCustomAdapter=new MyCustomAdapter(this, dt,picture);
        list.setAdapter(myCustomAdapter);



    }
}
