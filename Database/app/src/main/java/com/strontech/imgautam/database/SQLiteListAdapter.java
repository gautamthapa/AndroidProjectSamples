package com.strontech.imgautam.database;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by imgautam on 22/2/18.
 */

public class SQLiteListAdapter extends ArrayAdapter {

    Activity activity;
    List<Product> text,text2, text3;
    //Integer img[];
    //ImageView imgg;
    TextView txt1, txt2, txt3;
    MyDatabase db=new MyDatabase(getContext());
    List<Product> data=db.getAllProduct();
    Product ref;
    public SQLiteListAdapter(Activity activity, List<Product> text,List<Product> text2,List<Product> text3) {
        super(activity, R.layout.item_list_layout,text);
        this.activity=activity;
        //this.img=img;
        this.text=text;
        this.text2=text2;
        this.text3=text3;
    }

    public SQLiteListAdapter(DataView activity, int id, String name, String price) {
        super(activity, R.layout.item_list_layout, Integer.parseInt(price));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();
        View v=inflater.inflate(R.layout.item_list_layout,null);
        //imgg=v.findViewById(R.id.imageView);
        txt1=v.findViewById(R.id.textId);
        txt2=v.findViewById(R.id.textItem);
        txt3=v.findViewById(R.id.textPrice);

            txt1.setText(ref.getId());
            txt2.setText(ref.getName());
            txt3.setText(ref.getPrice());

        //imgg.setImageResource(img[position]);
        return v;
    }
}
