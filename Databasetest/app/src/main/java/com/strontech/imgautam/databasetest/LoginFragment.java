package com.strontech.imgautam.databasetest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    EditText edt1, edt2;
    Button btn1, btn2;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_login, container, false);

        edt1=v.findViewById(R.id.editText1);
        edt2=v.findViewById(R.id.editText2);
        btn1=v.findViewById(R.id.button1);
        btn2=v.findViewById(R.id.button2);

        return v;
    }

}
