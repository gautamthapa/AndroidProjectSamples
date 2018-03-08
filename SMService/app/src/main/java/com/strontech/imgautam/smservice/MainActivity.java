package com.strontech.imgautam.smservice;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.editText);
        edt2=findViewById(R.id.editText2);

        btn=findViewById(R.id.button);


        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
        {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},0);
            return;
        }


        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String phone=edt1.getText().toString();
                String msg=edt2.getText().toString();

                SmsManager smsManager=SmsManager.getDefault();

                smsManager.sendTextMessage(phone,null,msg,null,null);


                Toast.makeText(MainActivity.this, "Message sent...........", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
