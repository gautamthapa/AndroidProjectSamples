package com.strontech.imgautam.customdialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText edt1, edt2;
    Button btn;
    String name, ps;
    TextView txt, txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        txt = findViewById(R.id.textView4);
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.log_in_layout);

        dialog.setCancelable(false);
        edt1 = dialog.findViewById(R.id.editText2);
        edt2 = dialog.findViewById(R.id.editText3);
txt2=dialog.findViewById(R.id.textView51);
        btn = dialog.findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edt1.getText().toString().trim();
                ps = edt2.getText().toString().trim();

                if (name.equals("gtm") && ps.equals("12345")) {

                    txt.setText("Welcome " + name);
                    dialog.dismiss();
                } else {
                    txt2.setText("Invalid User");
                   int i=getResources().getColor(R.color.colorAccent);
                   txt2.setTextColor(i);
                    Toast.makeText(Main2Activity.this, "Invalid User", Toast.LENGTH_SHORT).show();
                }

            }
        });
        dialog.show();
    }
}
