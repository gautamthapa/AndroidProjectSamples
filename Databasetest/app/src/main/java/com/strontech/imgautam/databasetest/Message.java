package com.strontech.imgautam.databasetest;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by imgautam on 3/3/18.
 */

public class Message {

    public static void message(Context context, String message){

        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
