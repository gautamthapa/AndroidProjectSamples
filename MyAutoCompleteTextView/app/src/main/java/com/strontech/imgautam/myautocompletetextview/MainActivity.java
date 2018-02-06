package com.strontech.imgautam.myautocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn;
    AutoCompleteTextView act;
    ArrayList<String> l=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        act=findViewById(R.id.autoCompleteTextView);

        btn=findViewById(R.id.button);
       /*
       This is for static AutoCompleteTextView
       String dt[]=getResources().getStringArray(R.array.nme);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,l);
        act.setAdapter(adapter);
        act.setThreshold(1);  for starting search point

        */
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, R.layout.ll);
        act.setAdapter(adapter);
        act.setThreshold(1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  String s=act.getText().toString();
                l.add(s);
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,l);
                act.setAdapter(adapter);
                act.setThreshold(1);
                //adapter.notifyDataSetChanged(); */
              adapter.add(act.getText().toString());
              act.setText("");
                Toast.makeText(MainActivity.this, ""+l, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
