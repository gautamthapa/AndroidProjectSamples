package com.strontech.imgautam.courseapp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edt1, edt2;
    EditText sedt1;
    Spinner spn;
    Button btn;
    RadioButton cb1, cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.editText1);
        edt2 = findViewById(R.id.editText2);
        sedt1 = findViewById(R.id.simpleEditText);
        btn = findViewById(R.id.button);
        cb1 = findViewById(R.id.rb_btn1);
        cb2 = findViewById(R.id.rb_btn2);
        spn = findViewById(R.id.spinner1);

        sedt1.setFocusable(false);

        String[] data = getResources().getStringArray(R.array.course_name);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        spn.setAdapter(adapter);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 1) {
                    sedt1.setText("Manish sir");
                } else if (position == 2) {
                    sedt1.setText("Shubham Tripathi");
                } else if (position == 3) {
                    sedt1.setText("Gautam");
                } else {
                    sedt1.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rb_data, name, number, cName, gender, tName;
                if (cb1.isChecked()) {
                    //rb_data=cb1.getText().toString();
                    gender = "Mr.";
                } else {
                    //rb_data=cb2.getText().toString();
                    gender = "Mis.";
                }

                name = edt1.getText().toString();
                number = edt2.getText().toString();
                cName = spn.getSelectedItem().toString();
                tName=sedt1.getText().toString();

                if (name.equals("")) {
                    edt1.setError("Enter name");
                } else if (number.equals("")) {
                    edt2.setError("Enter number");
                } else if (spn.getSelectedItemPosition() == 0) {
                    Toast.makeText(MainActivity.this, "Please select course", Toast.LENGTH_SHORT).show();
                } else if (!(cb1.isChecked()) && !(cb2.isChecked())){
                    Toast.makeText(MainActivity.this, "Please select gender", Toast.LENGTH_SHORT).show();
                }else
                    {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("user_name", name);
                    intent.putExtra("mob_number", number);
                    intent.putExtra("course_name", cName);
                    intent.putExtra("gen", gender);
                    intent.putExtra("teacher",tName);
                    //intent.putExtra("female",gender);
                    startActivity(intent);
                }

            }
        });
    }
}
