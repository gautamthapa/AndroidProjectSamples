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
public class EightFragment extends Fragment {


    public EightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_eight, container, false);
        TextView txt=v.findViewById(R.id.textView7);
        Bundle b=getArguments();
        txt.setText(""+b.getString("yashpal"));
        return v;
    }

}
