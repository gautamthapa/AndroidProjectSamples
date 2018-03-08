package com.strontech.imgautam.customdialoghlogin;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    TextInputEditText edt1, edt2;
    String name,ps;
    TextView txt;

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=findViewById(R.id.textView);

        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.login_layout);

        btn1=dialog.findViewById(R.id.button1);
        btn2=dialog.findViewById(R.id.button2);
        edt1 = dialog.findViewById(R.id.edtText1);
        edt2 = dialog.findViewById(R.id.edtText2);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=edt1.getText().toString().trim();
                ps=edt2.getText().toString().trim();

                if (name.equals("")){
                    edt1.setError("Enter name");
                }else if (ps.equals("")){
                    edt2.setError("Enter password");
                }else {

                    if (name.equals("gtm") && ps.equals("12345")){
                        txt.setText("Welcome "+name);
                        Toast.makeText(MainActivity.this, "Successfully log in", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }else {
                        Toast.makeText(MainActivity.this, "Wrong Username & password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }
}
