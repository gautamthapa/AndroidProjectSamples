package com.strontech.imgautam.sharedpreferenceslogin;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
public class LoginFragment extends Fragment {

    Dialog dialog;

    EditText edt1, edt2;
    Button btn1, btn2;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    String name, ps;
    public String FILE="myfile";

    public LoginFragment() {
        // Required empty public constructor

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity().getActionBar()!=null){
            getActivity().getActionBar().hide();
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_login, container, false);
        edt1=v.findViewById(R.id.editText1);
        edt2=v.findViewById(R.id.editText2);
        btn1=v.findViewById(R.id.button1);
        btn2=v.findViewById(R.id.button2);

        pref=this.getActivity().getSharedPreferences(FILE, Context.MODE_PRIVATE);
        editor=pref.edit();


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
                name=edt1.getText().toString().trim();
                ps=edt2.getText().toString().trim();
               String getName=pref.getString("name_key",null);
               String getPass=pref.getString("ps_key",null);

                if (name.equals("")){
                    edt1.setError("Enter username");
                }else if (ps.equals("")){
                    edt2.setError("Enter password");
                }   else {

                    if (name.equals(getName) && ps.equals(getPass)){
                            Intent intent=new Intent(getActivity(), FirstActivity.class);
                            intent.putExtra("key_name",getName);
                            //intent.putExtra("key_pass",getPass);
                            startActivity(intent);

                        Toast.makeText(getActivity(), "Successfully login", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getActivity(), "Wrong Username & password", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        return v;

    }

}
