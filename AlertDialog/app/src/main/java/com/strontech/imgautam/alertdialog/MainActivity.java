package com.strontech.imgautam.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder ab;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ab = new AlertDialog.Builder(MainActivity.this);
                ab.setTitle("Android");
                ab.setIcon(R.mipmap.ic_launcher);
                ab.setMessage("aaj kuchh Tufani karte...");

                ab.setCancelable(false);  // this is for no close dialog click other part of app and baCK

                //set positive button and set event
                ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                        Toast.makeText(MainActivity.this, "Tufani ho jaye..", Toast.LENGTH_SHORT).show();
                    }
                });

                //set negative button and set event
                ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();  // dialog finish
                    }
                });
                ab.show();
            }
        });
    }
}
