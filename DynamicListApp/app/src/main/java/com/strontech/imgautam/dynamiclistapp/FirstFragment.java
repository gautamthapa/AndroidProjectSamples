package com.strontech.imgautam.dynamiclistapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    EditText edt;
    Button btn1, btn2;
    ListView listtt;
    ArrayList<String> al=new ArrayList<>();
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_first, container, false);
        edt = v.findViewById(R.id.editText4);
        btn1 = v.findViewById(R.id.button4);
        btn2 = v.findViewById(R.id.button5);

        View vv = inflater.inflate(R.layout.fragment_second, null);
        listtt = vv.findViewById(R.id.listView4);

        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,al);
        listtt.setAdapter(adapter);

        //final SecondFragment secondFragment = new SecondFragment();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt.getText().toString();
                if (name.equals("")) {
                    edt.setError("enter name");
                } else {
                al.add(name);
                adapter.notifyDataSetChanged();
                Bundle b=new Bundle();
                //b.putString(adapter);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.main_layout, new SecondFragment());
                ft.addToBackStack("hello");
                ft.commit();
            }
        });
        return v;
    }

}
