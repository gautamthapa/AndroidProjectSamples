package com.strontech.imgautam.loginusingfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    TextView txt1, txt2, txt3, txt4, txt5;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_second, container, false);

        txt1=v.findViewById(R.id.textView1);
        txt2=v.findViewById(R.id.textView2);
        txt3=v.findViewById(R.id.textView3);
        txt4=v.findViewById(R.id.textView4);
        txt5=v.findViewById(R.id.textView5);

        Bundle bundle=getArguments();
        txt1.setText(String.format("%s %s", bundle.getString("selected_gender"), bundle.getString("user_name")));
        txt2.setText(String.format("Name : %s", bundle.getString("user_name")));
        txt3.setText(String.format("Email id : %s", bundle.getString("email_id")));
        txt4.setText(String.format("Contact No. : %s", bundle.getString("mob_number")));
        txt5.setText(String.format("Course : %s", bundle.getString("course")));
        return v;
    }

}
