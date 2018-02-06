package com.strontech.imgautam.dynamiclistapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    //ListView listView;
    //ArrayList<String> al = new ArrayList<String>();

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);
      //  listView = v.findViewById(R.id.listView4);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, al);

        /*listView.setAdapter(adapter);
        Bundle b = getArguments();
        String s = b.getString("data");
            al.add(s);
*/
        return v;
    }

}
