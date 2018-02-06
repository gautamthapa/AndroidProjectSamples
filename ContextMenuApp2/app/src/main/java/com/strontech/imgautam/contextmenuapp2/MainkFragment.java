package com.strontech.imgautam.contextmenuapp2;


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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainkFragment extends Fragment {

    EditText edt;
    ListView list;
    ArrayAdapter<String> adapter;
    Button btn;
    String s;
    int position;
    //FloatingActionButton actionButton;
    ArrayList<String> al = new ArrayList<>();
    String ar[] = al.toArray(new String[0]);

    public MainkFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();

        Bundle b = getArguments();
        if (b == null) {
            Toast.makeText(getActivity(), "Sorry No data", Toast.LENGTH_SHORT).show();
        } else {

            String s = b.getString(("data"));
            al.add(s);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_maink, container, false);
        list = v.findViewById(R.id.listView);
        btn = v.findViewById(R.id.button11);
        edt = v.findViewById(R.id.editText11);
        registerForContextMenu(list);
        // actionButton=v.findViewById(R.id.floatingAdd);

        al.add("Java");
        al.add("C");
        al.add("C++");
        al.add("Python");
        al.add("Go");
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, al);
        list.setAdapter(adapter);
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                MainkFragment.this.position=position;
                return false;
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = edt.getText().toString();
                if (s.equals("")) {
                    edt.setError("Enter data");
                } else {
                    al.add(s);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        /*actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.main_layout, new FirstFragment());
                ft.addToBackStack("jj");
                ft.commit();
            }
        });*/
        return v;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Your Choice");
        menu.add("Edit");
        menu.add("Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle().equals("Edit")) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.main_layout, new FirstFragment());
            ft.addToBackStack("jj");
            ft.commit();

        } else {
            //int i=al.size();
            al.remove(position);
                adapter.notifyDataSetChanged();
            }
        }
        return super.onContextItemSelected(item);
    }
}