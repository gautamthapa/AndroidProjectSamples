package com.strontech.imgautam.camerause;


import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageButton imgBtn1, imgBtn2;

    ImageView img;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtn1 = findViewById(R.id.imageButton);
        imgBtn2 = findViewById(R.id.imageButton2);
        img = findViewById(R.id.imageView);

        imgBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


                //to get back clicked image from camera or to use image in app
                startActivityForResult(intent, 0);
            }
        });


    imgBtn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                getApplicationContext().setWallpaper(bitmap); // MainActivity.this.setWallpaper(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //request code: like key or position to make condition
        //result code : to ok or not ok for clicked image
        //data : to store image in int foarmat

        if (requestCode==0 && resultCode==RESULT_OK && data!=null)
        {

            Bundle b= data.getExtras();
            bitmap= (Bitmap) b.get("data");  //default key
            img.setImageBitmap(bitmap);

        }
        else
        {
            Toast.makeText(this, "pic click karo", Toast.LENGTH_SHORT).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }


}
