package com.strontech.imgautam.customlist;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by imgautam on 15/1/18.
 */

//here there is no default constructor in arrayAdapter
public class MyCustomAdapter extends ArrayAdapter {


    //create instance variable
    Activity activity;
    Integer img[];
    String text[];

    public MyCustomAdapter(Activity activity, String text[], Integer img[]) {
        //to run arraryadapter type constructor
        super(activity, R.layout.custom_layout, text);  // haha dikhega aur kesa dikhega, text for length of array position-
        this.activity = activity;
        this.img = img;
        this.text = text;
    }


    //This is
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();  //use activity reference to our class
        View v = inflater.inflate(R.layout.custom_layout, null);
        ImageView img1 = v.findViewById(R.id.imageView1);
        TextView txt = v.findViewById(R.id.textView1);


        img1.setImageResource(img[position]);
        txt.setText(text[position]);
        return v;
    }
}
