package com.strontech.imgautam.customlist1;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by imgautam on 16/1/18.
 */

public class MyCustomAdapter extends ArrayAdapter {
    Activity activity;
    String text[],text2[];
    Integer img[];
    ImageView imgg;
    TextView txt1, txt2;
    public MyCustomAdapter(Activity activity, String text[], String text2[], Integer img[]) {
        super(activity, R.layout.my_layout,text);
        this.activity=activity;
        this.img=img;
        this.text=text;
        this.text2=text2;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();
        View v=inflater.inflate(R.layout.my_layout,null);
        imgg=v.findViewById(R.id.imageView);
        txt1=v.findViewById(R.id.titleText);
        txt2=v.findViewById(R.id.descText);

        imgg.setImageResource(img[position]);
        txt1.setText(text[position]);
        txt2.setText(text2[position]);
return v;
    }
}
