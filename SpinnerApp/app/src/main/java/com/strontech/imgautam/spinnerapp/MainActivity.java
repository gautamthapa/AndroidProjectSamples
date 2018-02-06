package com.strontech.imgautam.spinnerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //String dt[] = {"India", "Nepal", "Bhutan", "Japan", "Thailand"};
    Spinner spr, spr2;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spr = findViewById(R.id.spinner1);
        spr2 = findViewById(R.id.spinner2);
        btn=findViewById(R.id.button1);
        spr2.setVisibility(View.GONE);

        String[] dtt = getResources().getStringArray(R.array.dt1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, dtt);

        //spinner.setPrompt("Select course");
        spr.setAdapter(adapter);
        //String dtt = getResources().getStringArray(R.array.dt);

        spr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //int i=spr.getSelectedItemPosition();
                if (position==1){
                    spr2.setVisibility(View.VISIBLE);
                    final String[] dtt1 = getResources().getStringArray(R.array.BTech);
                    ArrayAdapter<String> adapter1=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,dtt1);
                    spr2.setAdapter(adapter1);
                }else if (position==2){
                    spr2.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String vlue=spr.getSelectedItem().toString();
            Toast.makeText(MainActivity.this, ""+vlue, Toast.LENGTH_SHORT).show();


        }
    });
    }
}
