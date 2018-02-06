package com.strontech.imgautam.gridview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


/**
 * Created by imgautam on 23/1/18.
 */

public class MyCustomAdapter extends BaseAdapter {
    //to view the image in same activity
    Context context;
    Activity activity;
   // private String name[];
    //give the reference of activity

    public Integer pic[] =
            {
                    R.drawable.one,
                    R.drawable.two,
                    R.drawable.three,
                    R.drawable.four,
                    R.drawable.five,
            };

    public MyCustomAdapter(Context context){
        //this.activity=activity;
        this.context=context;
    }




    //how many data to view
    @Override
    public int getCount() {
        return pic.length;
    }

    @Override
    public Object getItem(int position) {
        return pic[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*
        View v;
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
        {
            v=new View(context);
            ImageView imageView=v.findViewById(R.id.imageView);
            TextView textView=v.findViewById(R.id.textView);
            imageView.setImageResource(pic[position]);
            textView.setText(name[position]);
        }else
        {
            v=(View) convertView;
        }

     /*  LayoutInflater layoutInflater=activity.getLayoutInflater();
        View v=layoutInflater.inflate(R.layout.my_layout,null);
        ImageView imageView=v.findViewById(R.id.imageView);
        TextView txt=v.findViewById(R.id.textView);
        imageView.setImageResource(pic[position]);
        txt.setText(name[position]);

*/

       //to set image
        ImageView imageView=new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(300, 300));// making layout for imageView
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8,8,8,8);

        imageView.setImageResource(pic[position]);

        return imageView;
    }
}
