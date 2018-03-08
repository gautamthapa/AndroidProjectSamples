package com.strontech.imgautam.patanjalistor;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by imgautam on 3/3/18.
 */

public class TestMessage {
    public static void message(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
