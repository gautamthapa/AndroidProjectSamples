package com.strontech.imgautam.customdialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;

    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //this is dialog used to create Dialog of custom layout
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom_dialog_layout);
                dialog.setCancelable(false);


                editText1 = dialog.findViewById(R.id.editText);
                btn2 = dialog.findViewById(R.id.button2);

                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String nme = editText1.getText().toString();
                        Toast.makeText(MainActivity.this, "" + nme, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                dialog.setTitle("Custom D");
                dialog.show();


            }
        });
    }


}
