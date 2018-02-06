package com.strontech.imgautam.customtoast;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    ImageView im1, im2;
    Button btn1, btn2;
    EditText edt1;
    View view;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn1 = findViewById(R.id.button2);
        btn2 = findViewById(R.id.button3);
        edt1 = findViewById(R.id.editText);
        // txt=findViewById(R.id.textView1);  this gives error because it does not found exact
        // textView in another layout file


        //===================================================================================================
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.custom_layout, null);

                //here we get the id of custom_layout component using view because after getting
                // the reference of that layout
                im2 = view.findViewById(R.id.imageView1);
                txt = view.findViewById(R.id.textView1);

                String s = edt1.getText().toString();
                if (s.equals("")) {
                    im2.setImageResource(R.drawable.angry_face);
                    txt.setText("Please enter name");
                } else {
                    im2.setImageResource(R.drawable.grinning_face);
                    txt.setText(String.format("welcome %s", s));
                }
                Toast toast = Toast.makeText(Main2Activity.this, "", Toast.LENGTH_SHORT);
                toast.setView(view);
                toast.show();
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater=getLayoutInflater();
                view=inflater.inflate(R.layout.custom_layout_process,null);
                ProgressBar progressBar;
                progressBar=view.findViewById(R.id.progressBar);
                Toast toast=Toast.makeText(Main2Activity.this, "", Toast.LENGTH_SHORT);
                toast.setView(view);
                toast.show();
            }
        });
    }
}
