package com.strontech.imgautam.contextmenuapp;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    EditText edt1, edt2, edt3;
    Button btn;
    ImageButton imgBtn;
    Bitmap bm;

    Integer[] img;
    String[] name;
    String[] desc, time;
    Activity activity;
    public FirstFragment() {
        // Required empty public constructor

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        edt1=v.findViewById(R.id.editText1);
        edt2=v.findViewById(R.id.editText2);
        edt3=v.findViewById(R.id.editText3);
        imgBtn=v.findViewById(R.id.imageButton);
        btn=v.findViewById(R.id.saveButton);


        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //to get back clicked image from camera or to use image in app
                startActivityForResult(intent, 0);
            }
        });

        //CustomAdapter customAdapter=new CustomAdapter()

        ListDetails ls=new ListDetails(img,name,desc,time);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edt1.getText().toString();
                String desc=edt2.getText().toString();
                String time=edt3.getText().toString();

                if (name.equals(""))
                {
                    edt1.setError("Enter name");
                } else if (desc.equals(""))
                {
                    edt2.setError("Enter desc");
                } else if (time.equals(""))
                {
                    edt3.setError("Enter time");
                }

                Bundle b=new Bundle();
                b.putString("datas",name);
                b.putString("desc",desc);
                b.putString("data",time);
       //         obj.setArguments(b);

            }
        });


         return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //request code: like key or position to make condition
        //result code : to ok or not ok for clicked image
        //data : to store image in int foarmat

        if (requestCode==0 && resultCode==RESULT_OK && data!=null)
        {


            Bundle b= data.getExtras();
            //bm= (Bitmap) b.("data",data);  //default key

        }
        else
        {
            Toast.makeText(getActivity(), "pic click karo", Toast.LENGTH_SHORT).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}
