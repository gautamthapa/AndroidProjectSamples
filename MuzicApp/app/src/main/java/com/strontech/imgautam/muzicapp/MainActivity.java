package com.strontech.imgautam.muzicapp;


import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    ImageButton playBtn, nextBtn, preBtn, pauseBtn;
    MediaPlayer mediaPlayer;
    Integer aSong;
    Integer song[]=
            {
                    R.raw.goliyan,
                    R.raw.munde,
                    R.raw.sajde,
                    R.raw.sharry
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img=findViewById(R.id.imageView);
        pauseBtn=findViewById(R.id.pauseButton);
        nextBtn=findViewById(R.id.nextButton);
        preBtn=findViewById(R.id.prevButton);
        playBtn=findViewById(R.id.playButton);

        for (int i=0; i<song.length; i++) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), song[i]);
        }

        preBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=v.getId();
                if (i==playBtn.getId())
                {
                    mediaPlayer.start();
                    playBtn.setVisibility(View.GONE);
                    pauseBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=v.getId();
                if (i==pauseBtn.getId())
                {
                    mediaPlayer.pause();
                    playBtn.setVisibility(View.VISIBLE);
                    pauseBtn.setVisibility(View.GONE);
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mediaPlayer.stop();

                for (int i=0; i<song.length; i++) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), song[i]);
                }
                mediaPlayer.start();
            }
        });

        preBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // mediaPlayer.stop();
                for (int i=0; i<song.length; i++) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), song[i]);
                }
                mediaPlayer.start();
            }
        });
    }
}
