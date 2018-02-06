package com.strontech.imgautam.gridview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    public Integer pic[] =
            {
                    R.drawable.one,
                    R.drawable.two,
                    R.drawable.three,
                    R.drawable.four,
                    R.drawable.five,
            };
    public String name[] =
            {
                    "One",
                    "Two",
                    "Three",
                    "Four",
                    "Five"
            };

    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridView1);


        MuCustomAdapter muCustomAdapter=new MuCustomAdapter(this, pic,name);
        gridView.setAdapter(muCustomAdapter);
    }
}
