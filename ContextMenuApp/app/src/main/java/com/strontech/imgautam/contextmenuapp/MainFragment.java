package com.strontech.imgautam.contextmenuapp;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    ListView list;
    FloatingActionButton fabButton;

    public Integer img[];//={
      //      R.drawable.ic_launcher_background,
        //    R.drawable.ic_launcher_foreground
    //};

    public String name[];//={"hello", "gautam"};
    public String desc[];//={"kkk","nfjkdnfk"};
    public String time[];//={"12:30","1:00"};

    ArrayList<String>al=new ArrayList<>();

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        list = v.findViewById(R.id.listView);
        fabButton=v.findViewById(R.id.floatingAdd);

        registerForContextMenu(list);

        CustomAdapter cAdapter=new CustomAdapter(getActivity(),al);
        list.setAdapter(cAdapter);

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.main_activity, new FirstFragment());
                ft.addToBackStack("hello");
                ft.commit();
            }
        });

        return v;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Your choice");
        menu.add("Edit");
        menu.add("Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

       if (item.getTitle().equals("Edit"))
       {
           FragmentManager fm=getFragmentManager();
           FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.main_activity, new FirstFragment());
            ft.addToBackStack("exit");
            ft.commit();
       }else
       {

       }

        return super.onContextItemSelected(item);
    }
}
