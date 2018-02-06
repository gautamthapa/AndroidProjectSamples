package com.strontech.imgautam.useoffragment;


import android.os.Bundle;
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


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_login, container, false);
        final EditText edt1=view.findViewById(R.id.editText);
        final EditText edt2=view.findViewById(R.id.editText2);
        Button btn=view.findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nme, ps;
                nme=edt1.getText().toString();
                ps=edt2.getText().toString();
                if (nme.equals("")){
                    edt1.setError("plz enter name");
                }else if (ps.equals("")){
                    edt2.setError("plz enter password");
                }else{

                    int psd= Integer.parseInt(edt2.getText().toString());
                    if (nme.equals("Ducat") && psd==12345){
                        FragmentManager fm=getFragmentManager();
                        FragmentTransaction ft=fm.beginTransaction();
                        ft.replace(R.id.min, new SecondFragment());
                        ft.addToBackStack(null); // this is add fragment into back stack
                        ft.commit();
                    }
                    else {
                        Toast.makeText(getActivity(), "Invalid user", Toast.LENGTH_SHORT).show();
                    edt1.setText("");
                    edt2.setText("");
                    }
                }
                }
        });
        return view;
    }

}
