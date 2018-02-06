package com.strontech.imgautam.contetmenuapp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    EditText edt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edt = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        Bundle b = getIntent().getExtras();
        edt.setText(b.getString("name_key"));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result = edt.getText().toString().trim();
                if (result.equals("")) {
                    edt.setError("Please rename");
                } else {
                    Intent i = new Intent();
                    i.putExtra("result",result);
                    setResult(RESULT_OK,i);  //to send data back
                    finish();
                }

            }
        });
    }
}
