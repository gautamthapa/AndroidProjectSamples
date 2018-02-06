package com.strontech.imgautam.customtoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);

        imageView=findViewById(R.id.img2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //to inflate the layout in required compotent
                LayoutInflater inflater=getLayoutInflater();
                View view=inflater.inflate(R.layout.my_layout,null);

                // to show layout in Toast
                Toast toast=Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT);
                toast.setView(view);
                toast.setGravity(Gravity.CLIP_VERTICAL,10, 10);
                toast.show();

            }
        });
    }
}
