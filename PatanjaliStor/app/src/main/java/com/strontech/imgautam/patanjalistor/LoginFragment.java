package com.strontech.imgautam.patanjalistor;


import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    Button btn1, btn2;

    String mUsername, mPass;
    SharedPreferences pref;

    UserInfoDatabase database;
    TextInputEditText mEdt_username, mEdt_pass;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        btn1 = v.findViewById(R.id.btn_login);
        btn2 = v.findViewById(R.id.btn_signup);
        mEdt_username = v.findViewById(R.id.edtUsername);
        mEdt_pass = v.findViewById(R.id.edtPassword);

        database=new UserInfoDatabase(getActivity());

        pref = this.getActivity().getSharedPreferences("myFile", Context.MODE_PRIVATE);

        mUsername = pref.getString("key_mUsername", null);
        mPass = pref.getString("key_mPass", null);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mmUsername, mmPass;
                mmUsername = mEdt_username.getText().toString().trim();
                mmPass = mEdt_pass.getText().toString().trim();

                if (mmUsername.equals("")) {
                    mEdt_username.setError("Enter username");
                } else if (mmPass.equals("")) {
                    mEdt_pass.setError("Enter Password");
                } else{





                    UserInfo userInfo=database.getNamePass(mmUsername,mmPass);

                    String getName=userInfo.getEmail();
                    String getPass=userInfo.getMob_number();

                    if (getName.equals(mmUsername) && getPass.equals(mmPass))
                    {
                        FragmentTransaction ft=getFragmentManager().beginTransaction();
                        ft.replace(R.id.main_layout,new UserMainFragment());
                        ft.commit();
                    }else if (mUsername.equals(mmUsername) && mPass.equals(mmPass)) {
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.main_layout, new MerMainFragment());
                        ft.addToBackStack("From Main Merchant");
                        ft.commit();
                        Toast.makeText(getActivity(), "Successfully logged in", Toast.LENGTH_SHORT).show();
                    } else if (mUsername == null && mPass == null) {
                        Toast.makeText(getActivity(), "Wrong Username and password", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Invalid username & password", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ;
                ft.replace(R.id.main_layout, new SelectFragment());
                ft.addToBackStack("selectFragment");
                ft.commit();
            }
        });

        return v;
    }

}
