package com.strontech.imgautam.telephonyservices;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button btn, btn2;

    TelephonyManager tm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.textView);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);

        //to get service of telephony
        tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        txt.setText("" + tm.getNetworkOperatorName());


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:8467090016"));

                //Runtime permission
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling


                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},0);
                    return;
                }
                startActivity(intent);    //no require of user get permission.. in api 21
        }
    });

    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent=new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:8467090016"));
            startActivity(intent);
        }
    });

    }
}
