package com.strontech.imgautam.gmailapinewdemo;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MainActivity extends AppCompatActivity implements OnClickListener {

  private TextInputEditText textInputEditTextUsername;
  private TextInputEditText textInputEditTextPhone;
  private TextInputEditText textInputEditTextEmail;
  private TextInputEditText textInputEditTextAddress;
  private Button buttonRegister;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initViews();
    initListeners();

  }

  private void initViews() {
    textInputEditTextUsername = findViewById(R.id.edt_username_user);
    textInputEditTextPhone = findViewById(R.id.edt_mobile_user);
    textInputEditTextEmail = findViewById(R.id.edt_email_user);
    textInputEditTextAddress = findViewById(R.id.edt_address_user);

    buttonRegister = findViewById(R.id.btn_user_sub);
  }


  private void initListeners() {
    buttonRegister.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.btn_user_sub:
        userRegisteredNotify();
        break;
    }
  }


  private void userRegisteredNotify() {
    // it has to to send .. so we use Thread
    Thread t=new Thread()
    {
      public void run()
      {
        //it shows time duration....
        //Toast.makeText(MainActivity.this, "Jaduuuu", Toast.LENGTH_SHORT).show();

        // Log.d("TAG","welcome thread");


        String toMail=textInputEditTextEmail.getText().toString().trim();
        String sub="test";
        String msgg="hello";

        String from="gautam.thapa22@gmail.com";
        String password="creation12thapan";
        String to=toMail;
        String host="smtp.gmail.com";

        try
        {

          //first time authentication then saved as session
          Properties p=new Properties();
          Session sess=Session.getInstance(p);

          //for manage message session
          MimeMessage msg=new MimeMessage(sess);



          //internetAddress  --Google Email API
          InternetAddress toId=new InternetAddress(to);
          InternetAddress fromId=new InternetAddress(from);




          msg.setFrom(fromId);

          msg.setRecipient(Message.RecipientType.TO,toId);

          msg.setSubject(sub);
          msg.setText(msgg);

          //Transport.. read mailing and transport
          Transport tpt=sess.getTransport("smtps");
          tpt.connect(host,from,password);

          tpt.sendMessage(msg,msg.getAllRecipients());

          tpt.close();
        }catch (Exception e)
        {
          Log.e("TAG","WRONG EMAIL&PASSWORD");
        }
      }

    };
    t.start();

  }
}

