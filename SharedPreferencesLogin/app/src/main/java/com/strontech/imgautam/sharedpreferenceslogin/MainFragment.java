package com.strontech.imgautam.sharedpreferenceslogin;


import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    Dialog dialog;

    EditText edt1, edt2;
    Button btn1, btn2;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    String name, ps;
    final private String FILE="myfile";
    public MainFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_main, container, false);
/*
        dialog=new Dialog(getActivity(),android.R.style.Theme_Material_Light_NoActionBar_Fullscreen);
        dialog.setContentView(R.layout.diallog_login);


        edt1=dialog.findViewById(R.id.editText1);
        edt2=dialog.findViewById(R.id.editText2);
        btn1=dialog.findViewById(R.id.button1);
        btn2=dialog.findViewById(R.id.button2);

        pref=this.getActivity().getSharedPreferences(FILE, Context.MODE_PRIVATE);
        editor=pref.edit();



        dialog.show();
        //register
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=edt1.getText().toString().trim();
                ps=edt2.getText().toString().trim();

                if (name.equals(""))
                {
                    edt1.setError("Enter username");
                }else if (ps.equals("")){
                    edt2.setError("Enter password");
                }else {
                    editor.putString("name_key",name);
                    editor.putString("ps_key",ps);
                    editor.commit();

                    Toast.makeText(getActivity(), "Successfully registered", Toast.LENGTH_SHORT).show();

                    edt1.setText("");
                    edt2.setText("");
                }


            }
        });


        //String edtName, edtPs;
        //login
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


  //              if (getActivity() != null) {
//your code
//FragmentManager fm=this.getFragmentManager();
                LoginFragment loginFragment=new LoginFragment();
                    FragmentTransaction ft=getFragmentManager().beginTransaction();
                    ft.replace(R.id.main_layout,new LoginFragment());
                    ft.commit();
    //            }


                /*
                name=edt1.getText().toString().trim();
                ps=edt2.getText().toString().trim();
               String getName=pref.getString("name_key",null);
               String getPass=pref.getString("ps_key",null);


                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.main_layout,new LoginFragment());
                ft.commit();

                if (name.equals("")){
                    edt1.setError("Enter username");
                }else if (ps.equals("")){
                    edt2.setError("Enter password");
                }else {

                    if (name.equals(getName) && ps.equals(getPass)){


                        Toast.makeText(getActivity(), "Successfully login", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getActivity(), "Wrong Username & password", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
*/

        return v;
    }

}
