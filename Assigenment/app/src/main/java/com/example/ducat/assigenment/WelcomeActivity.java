package com.example.ducat.assigenment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {


    private android.widget.TextView textView;

    String name;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        textView = (TextView) findViewById(R.id.textView);
        pref=getSharedPreferences("myfile", Context.MODE_PRIVATE);
        editor=pref.edit();
      Bundle b= getIntent().getExtras();

        name=b.getString("name_key");
        textView.setText(""+name);
    }

    @Override
    public void onBackPressed()
    {
        if(pref.getString("name",null)!=null)
        {
            dialog();
        }
        else {
            super.onBackPressed();
        }
        }

        public void dialog()
        {
            AlertDialog.Builder ab=new AlertDialog.Builder(this);
            ab.setMessage("Do you want to exit..?");
            ab.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    WelcomeActivity.this.finish();
                }
            });
            ab.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            ab.show();
        }

}
