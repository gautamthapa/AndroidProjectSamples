package com.strontech.imgautam.contextmenuapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by imgautam on 31/1/18.
 */

public class CustomAdapter extends ArrayAdapter {

    Integer[] img;
    String[] name;
    String[] desc, time;
    Activity activity;

    CircleImageView circleImageView;
    TextView titleTxt, descTxt, timeTxt;
    ArrayList<String> al = new ArrayList<String>();

    public CustomAdapter(Activity activity, ArrayList<String> al) {
        super(activity, R.layout.my_custom_layout);
        this.activity = activity;
        this.al=al;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.my_custom_layout, null);

        circleImageView = v.findViewById(R.id.profile_image);
        titleTxt = v.findViewById(R.id.textViewTitle);
        descTxt = v.findViewById(R.id.msgTextView);
        timeTxt = v.findViewById(R.id.timeTextView);


        circleImageView.setImageResource(img[position]);
        titleTxt.setText(name[position]);
        descTxt.setText(desc[position]);
        timeTxt.setText(time[position]);

        return v;
    }
}
