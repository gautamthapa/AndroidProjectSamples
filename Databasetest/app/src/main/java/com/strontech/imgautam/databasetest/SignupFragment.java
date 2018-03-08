package com.strontech.imgautam.databasetest;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment {

    TextInputEditText edt1, edt2, edt3, ed4;
    Button btn, btn1;

    UserDatabase database;
    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_signup, container, false);

        edt1=v.findViewById(R.id.edt_username_user);
        edt2=v.findViewById(R.id.edt_email_user);
        edt3=v.findViewById(R.id.edt_mobile_user);
        ed4=v.findViewById(R.id.edt_address_user);
        btn=v.findViewById(R.id.btn_user_sub);
        btn1=v.findViewById(R.id.btn_user_show);

        database=new UserDatabase(getActivity());

        //SQLiteDatabase db=database.getReadableDatabase();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, email, mob_number, address;
                name= edt1.getText().toString().trim();
                email= edt2.getText().toString().trim();
                mob_number= edt3.getText().toString().trim();
                address= ed4.getText().toString().trim();

                UserInfo userInfo=new UserInfo();
                userInfo.setUserName(name);
                userInfo.setEmail(email);
                userInfo.setMob_number(mob_number);
                userInfo.setAddress(address);

                database.addUser(userInfo);

                Message.message(getActivity(), "Data saved");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<UserInfo> data=database.getAllData();
                for(UserInfo ref:data)
                {
                    Message.message(getActivity(),ref.getUserName()+"\n"+ref.getEmail()+"\n"+
                    ref.getMob_number()+"\n"+ref.getAddress());
                }
            }
        });





        return v;
    }

}
