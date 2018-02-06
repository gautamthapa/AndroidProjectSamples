package com.strontech.imgautam.customlist1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public Integer img[] =
            {
                    R.drawable.ic_android_black_24dp,
                    R.drawable.ic_android_black_24dp,
                    R.drawable.ic_android_black_24dp,
                    R.drawable.ic_android_black_24dp,
                    R.drawable.ic_android_black_24dp,
                    R.drawable.ic_android_black_24dp,
            };
    public String mName[], mDesc[];
    //ListView list;
GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
      //  list = findViewById(R.id.listView1);
            gridView=findViewById(R.id.gridView1);

        mName = getResources().getStringArray(R.array.title);
        mDesc = getResources().getStringArray(R.array.desc);


        MyCustomAdapter myCustomAdapter = new MyCustomAdapter(this, mName, mDesc, img);
        gridView.setAdapter(myCustomAdapter);
    }
}
