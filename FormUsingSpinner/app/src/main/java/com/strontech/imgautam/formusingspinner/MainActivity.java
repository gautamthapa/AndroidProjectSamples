package com.strontech.imgautam.formusingspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spn1, spn2;
    EditText edt1, edt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1=findViewById(R.id.spinner1);
        spn2=findViewById(R.id.spinner2);
        edt1=findViewById(R.id.editText1);
        edt2=findViewById(R.id.editText2);

        spn2.setVisibility(View.GONE);


        String[] state=getResources().getStringArray(R.array.statesData);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,state);
        spn1.setAdapter(adapter);
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position==11){
                    String[] district=getResources().getStringArray(R.array.districtData);
                    ArrayAdapter<String> adapter1=new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1,district);
                    spn2.setAdapter(adapter1);
                    spn2.setVisibility(View.VISIBLE);
                }
                else if (position == 1){
                    String[] conty=getResources().getStringArray(R.array.country);
                    ArrayAdapter<String> adapter2=new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1,conty);
                    spn2.setAdapter(adapter2);
                    spn2.setVisibility(View.VISIBLE);
                    //spn2.setVisibility(View.INVISIBLE);
                }else if (position==0)
                    spn2.setVisibility(View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
