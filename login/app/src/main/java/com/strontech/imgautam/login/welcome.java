package com.strontech.imgautam.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class welcome extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String nme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView textView=findViewById(R.id.textView);

        pref=getSharedPreferences("myfile", Context.MODE_PRIVATE);
        editor=pref.edit();

        Bundle b=getIntent().getExtras();
        nme=b.getString("nme_key");
        textView.setText(""+nme);
    }

    @Override
    public void onBackPressed() {

        if (pref.getString())
        super.onBackPressed();
    }

    public void Dialog()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Exit");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        })
    }
}
