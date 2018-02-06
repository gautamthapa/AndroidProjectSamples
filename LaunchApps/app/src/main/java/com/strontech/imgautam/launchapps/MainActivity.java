package com.strontech.imgautam.launchapps;

import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn;
    ImageButton btnn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn1 = findViewById(R.id.button2);
        btnn=findViewById(R.id.imageButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //For opening internal setting
                //Intent intent = new Intent(Settings.ACTION_SETTINGS);


                Intent intent =  new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
               // this is for opening contacts
                startActivity(intent);
            }
        });

        //this is for external apps
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                startActivity(i);
               // startActivityForResult();  for transfer data from one activity n another app
            }
        });
    btnn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.googleassistant");
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Image Button clicked", Toast.LENGTH_SHORT).show();
        }
    });
    }


}
