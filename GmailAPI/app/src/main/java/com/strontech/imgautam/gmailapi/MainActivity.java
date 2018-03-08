package com.strontech.imgautam.gmailapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edt1, edt2, edt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button);
        edt1=findViewById(R.id.editText);
        edt2=findViewById(R.id.editText2);
        edt3=findViewById(R.id.editText3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // it has to to send .. so we use Thread
                Thread t=new Thread()
                {
                    public void run()
                    {
                        //it shows time duration....
                        //Toast.makeText(MainActivity.this, "Jaduuuu", Toast.LENGTH_SHORT).show();

                       // Log.d("TAG","welcome thread");


                        String toMail=edt1.getText().toString();
                        String sub=edt2.getText().toString();
                        String msgg=edt3.getText().toString();

                        String from="imstar1lord@gmail.com";
                        String password="gtm123imstar";
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
        });
    }
}
