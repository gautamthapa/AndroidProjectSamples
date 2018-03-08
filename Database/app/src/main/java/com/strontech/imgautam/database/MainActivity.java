package com.strontech.imgautam.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2, edt3;
    Button btn1, btn2, btn3, btn4, btn5;

    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.editText1);
        edt2 = findViewById(R.id.editText2);
        edt3 = findViewById(R.id.editText3);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);

        db = new MyDatabase(this);  // this to run the constructor of MyDatabase

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(edt1.getText().toString());
                String name = edt2.getText().toString();
                String price = edt3.getText().toString();

                Product product = new Product();
                product.setId(id);
                product.setName(name);
                product.setPrice(price);

                db.addProduct(product);

                Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Intent intent=new Intent(MainActivity.this, DataView.class);
                //startActivity(intent);

                List<Product> data = db.getAllProduct();

                for (Product ref : data) {
                    Toast.makeText(MainActivity.this,
                            "Id:- " + ref.getId() + "\nNameL:- " + ref.getName() + "\nPrice:- " + ref.getPrice(), Toast.LENGTH_SHORT).show();
                }


            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(edt1.getText().toString());

                Product product = db.getSingleProduct(id);
                int i = product.getId();
                String n = product.getName();
                String p = product.getPrice();

                Toast.makeText(MainActivity.this, "Id:-" + i + "\nName:-" + n + "\nPrice:-" + p, Toast.LENGTH_SHORT).show();
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(edt1.getText().toString());
                String name = edt2.getText().toString();
                String price = edt3.getText().toString();

                Product product = new Product();
                product.setId(id);
                product.setName(name);
                product.setPrice(price);

                db.addProduct(product);

int res=db.updateProduct(product);

                if (res>0)
                {
                    Toast.makeText(MainActivity.this, "Record update", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "No update", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(edt1.getText().toString());
                db.deleteProduct(id);
                Toast.makeText(MainActivity.this, "deleted..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
