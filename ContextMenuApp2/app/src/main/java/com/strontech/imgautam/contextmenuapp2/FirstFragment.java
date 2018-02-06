package com.strontech.imgautam.contextmenuapp2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    EditText edt;
    Button btn;
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_first, container, false);
        edt=v.findViewById(R.id.editText);
        btn=v.findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainkFragment mf=new MainkFragment();
                String data=edt.getText().toString();
                if (data.equals(""))
                {
                    edt.setError("enter name");
                }else
                {
                    Bundle b=new Bundle();
                    b.putString("data",data);
                    mf.setArguments(b);
                }
            }
        });

        return v;
    }

}
