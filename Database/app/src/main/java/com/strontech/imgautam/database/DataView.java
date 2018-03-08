package com.strontech.imgautam.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class DataView extends AppCompatActivity {

    ListView listView;
    MyDatabase db;
    //SQLiteListAdapter ListAdapter
    String[] name, price;
    Integer[] id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_view);

        db = new MyDatabase(this);

        List<Product> data=db.getAllProduct();


        for (Product ref:data)
        {
           /// text=data.add(0,ref.getId());
            Toast.makeText(DataView.this,
                    "Id:- "+ ref.getId()+"\nNameL:- "+ref.getName()+"\nPrice:- "+ref.getPrice(), Toast.LENGTH_SHORT).show();
       SQLiteListAdapter adapter=new SQLiteListAdapter(this,ref.getId(),ref.getName(),ref.getPrice());
        }
    }
}
