package com.strontech.imgautam.alertdialogapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    TextView txt1, txt2, txt3, txt4, txt5;
    String gGender, gName, gEmail, gNumber, gCourse;
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_first, container, false);

        txt1=v.findViewById(R.id.textView1);
        txt2=v.findViewById(R.id.textView2);
        txt3=v.findViewById(R.id.textView3);
        txt4=v.findViewById(R.id.textView4);
        txt5=v.findViewById(R.id.textView5);

        Bundle b=getArguments();

        txt1.setText(""+b.getString("key_gender")+b.getString("key_name"));
        txt2.setText("Name: "+b.getString("key_name"));
        txt3.setText("Email: "+b.getString("key_email"));
        txt4.setText("Number: "+b.getString("key_number"));
        txt5.setText("Course: "+b.getString("key_course"));

        return v;
    }

}
