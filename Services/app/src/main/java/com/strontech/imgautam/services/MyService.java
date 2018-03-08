package com.strontech.imgautam.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    MediaPlayer mp;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }


    @Override
    public void onCreate() {
        //super.onCreate();
        mp=MediaPlayer.create(getApplicationContext(),R.raw.goliy);
        Toast.makeText(this, "Service created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        //super.onStart(intent, startId);

        mp.start();
        Toast.makeText(this, "Service started...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
       // super.onDestroy();

        mp.stop();
        Toast.makeText(this, "Service destroyed...", Toast.LENGTH_SHORT).show();
    }
}
