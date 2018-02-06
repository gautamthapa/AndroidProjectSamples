package com.strontech.imgautam.menuoptionapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
/*
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        switch(id)
        {
            case R.id.item1:

                ft.replace(R.id.main_layout, new LoginFragment());
                ft.addToBackStack("MainActivity");
                ft.commit();
                break;
            case R.id.item2:
                ft.replace(R.id.main_layout, new RegisterFragment());
                ft.addToBackStack("MainActivity");
                break;
            case R.id.item3:
                ft.replace(R.id.main_layout, new LoginFragment());
                ft.addToBackStack("MainActivity");
                ft.commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
*/

}
