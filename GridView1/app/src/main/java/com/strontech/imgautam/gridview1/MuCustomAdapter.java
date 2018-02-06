package com.strontech.imgautam.gridview1;

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
 * Created by imgautam on 23/1/18.
 */


public class MuCustomAdapter extends ArrayAdapter {

    String name[];
    Integer img[];
    TextView txt;
    Activity activity;
    public MuCustomAdapter(@NonNull Activity activity, Integer img[], String name[] ) {
        super(activity, R.layout.my_layout,name);
        this.activity=activity;
        this.img=img;
        this.name=name;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



        LayoutInflater inflater=activity.getLayoutInflater();
        View v=inflater.inflate(R.layout.my_layout,null);
        ImageView imageView=v.findViewById(R.id.imageView1);
        TextView textView=v.findViewById(R.id.textView1);

        imageView.setImageResource(img[position]);
        textView.setText(name[position]);


        return v;
    }
}
