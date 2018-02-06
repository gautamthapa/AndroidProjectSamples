package com.strontech.imgautam.simplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class who extends AppCompatActivity {

    EditText edt1;
    Button btn;
TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who);

        edt1=findViewById(R.id.enter_ge);
        btn=findViewById(R.id.vlidte);
        txt=findViewById(R.id.txttt);



    /*    btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=Integer.parseInt(edt1.getText().toString());

                if (i<=5){
                    Toast.makeText(who.this, "Go for polio drop", Toast.LENGTH_SHORT).show();
                } else if (i>5 && i<=10){
                    Toast.makeText(who.this, "Go for tblets", Toast.LENGTH_SHORT).show();
                }else if (i>10 && i<=15){
                    Toast.makeText(who.this, "Gor for injection", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(who.this, "bet ghr jo", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }
}
