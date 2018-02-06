package com.strontech.imgautam.listviewuseapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FourthFragment extends Fragment {


    public FourthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_fourth, container, false);
        TextView txt=v.findViewById(R.id.textView3);
        Bundle b=getArguments();
        txt.setText(""+b.getString("krishna"));
        return v;
    }

}
