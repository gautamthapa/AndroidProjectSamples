package com.strontech.imgautam.manageprofile;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {

  RadioButton btn_silent, btn_vibrate, btn_normal;
  AudioManager audioManager;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btn_silent=findViewById(R.id.silent);
    btn_vibrate=findViewById(R.id.vibrate);
    btn_normal=findViewById(R.id.normal);

    audioManager= (AudioManager) getSystemService(AUDIO_SERVICE);

    btn_silent.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
      }
    });

    btn_vibrate.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
      }
    });

    btn_normal.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
      }
    });
  }
}
