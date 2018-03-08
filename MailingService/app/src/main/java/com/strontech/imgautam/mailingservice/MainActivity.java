package com.strontech.imgautam.mailingservice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2, edt3;
    Button btn;

    String t,s,m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.editText);
        edt2=findViewById(R.id.editText2);
        edt3=findViewById(R.id.editText3);

        btn=findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t=edt1.getText().toString();
                s=edt2.getText().toString();
                m=edt3.getText().toString();

                String too[]={t};  //To in email

                sendEmil(too,s,m);
            }
        });
    }

    private void sendEmil(String emailAddress[], String subject, String message)
    {
        Intent emailIntent=new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL,emailAddress);

        emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);

        emailIntent.putExtra(Intent.EXTRA_TEXT,message);
        emailIntent.setType("message/utf-8");
        startActivity(Intent.createChooser(emailIntent,"Email"));
    }
}
