package com.strontech.imgautam.apphub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    ImageButton btn_a, btn_w, btn_i, btn_h, btn_t, btn_m, btn_p, btn_c;

    LinearLayout la, lw, li, lh, lt, lm, lp, lc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btn_a=findViewById(R.id.aButton);
        btn_w=findViewById(R.id.wButton);
        btn_i=findViewById(R.id.iButton);
        btn_h=findViewById(R.id.hButton);
        btn_t=findViewById(R.id.tButton);
        btn_m=findViewById(R.id.mButton);
        btn_p=findViewById(R.id.pButton);
        btn_c=findViewById(R.id.cButton);

       /*la=findViewById(R.id.aLayout);
       lw=findViewById(R.id.wLayout);
       li=findViewById(R.id.iLayout);
       lh=findViewById(R.id.hLayout);
       lt=findViewById(R.id.tLayout);
       lm=findViewById(R.id.mLayout);
       lp=findViewById(R.id.pLayout);
       lc=findViewById(R.id.cLayout);*/

       btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.googleassistant");
                startActivity(intent);
            }
        });
       btn_w.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
               startActivity(intent);
           }
       });
       btn_i.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = getPackageManager().getLaunchIntentForPackage("com.instagram.android");
               startActivity(intent);
           }
       });
        btn_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.bsb.hike");
                startActivity(intent);
            }
        });
        btn_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.twitter.android");
                startActivity(intent);
            }
        });
        btn_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.facebook.orca");
                startActivity(intent);
            }
        });
        btn_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.music");
                startActivity(intent);
            }
        });
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.calendar");
                startActivity(intent);
            }
        });

    }
/*
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.aLayout) {
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.googleassistant");
            startActivity(intent);
        } else if (i == R.id.wLayout) {
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
            startActivity(intent);
        } else if (i == R.id.iLayout) {
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.instagram.android");
            startActivity(intent);
        } else if (i == R.id.hLayout) {
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.bsb.hike");
            startActivity(intent);
        } else if (i == R.id.tLayout) {
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.twitter.android");
            startActivity(intent);
        } else if (i == R.id.mLayout) {
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.facebook.orca");
            startActivity(intent);
        } else if (i == R.id.pLayout) {
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.music");
            startActivity(intent);
        } else if (i == R.id.cLayout) {
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.calendar");
            startActivity(intent);
        } else {
            Toast.makeText(this, "Do nothing", Toast.LENGTH_SHORT).show();
        }

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.googleassistant");
                startActivity(intent);
            }
        });
    }*/
}
