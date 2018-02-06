package com.strontech.imgautam.listviewuseapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    ListView list1;
    String data[], t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_first, container, false);
        list1=v.findViewById(R.id.listView1);

        data=getResources().getStringArray(R.array.hindi_writers);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);
        list1.setAdapter(adapter);

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    SecondFragment secondFragment=new SecondFragment();
                    t1=(list1.getItemAtPosition(position)).toString();
                    Bundle b=new Bundle();
                    b.putString("munsi",t1);
                    secondFragment.setArguments(b);

                    FragmentManager fm=getFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.main_layout,secondFragment);
                    ft.addToBackStack("Main");
                    ft.commit();
                }else if (position==1){
                    ThirdFragment thirdFragment=new ThirdFragment();
                    t2=(list1.getItemAtPosition(position)).toString();
                    Bundle b=new Bundle();
                    b.putString("dharam",t2);
                    thirdFragment.setArguments(b);
                    FragmentManager fm=getFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.main_layout, thirdFragment);
                    ft.addToBackStack("Main");
                    ft.commit();
                }else if (position==2){

                    FourthFragment fourthFragment=new FourthFragment();
                    t3=(list1.getItemAtPosition(position)).toString();
                    Bundle b=new Bundle();
                    b.putString("krishna",t3);
                    fourthFragment.setArguments(b);
                    FragmentManager fm=getFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.main_layout,fourthFragment);
                    ft.addToBackStack("Main");
                    ft.commit();
                }else if (position==3){
                    FifthFragment fifthFragment=new FifthFragment();
                    t4=(list1.getItemAtPosition(position)).toString();
                    Bundle b=new Bundle();
                    b.putString("bisham",t4);
                    fifthFragment.setArguments(b);
                    FragmentManager fm=getFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.main_layout,fifthFragment);
                    ft.addToBackStack("Main");
                    ft.commit();
                }else if (position==4){
                    SixthFragment sixthFragment=new SixthFragment();
                    t5=(list1.getItemAtPosition(position)).toString();
                    Bundle b=new Bundle();
                    b.putString("kamal",t5);
                    sixthFragment.setArguments(b);
                    FragmentManager fm=getFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.main_layout,sixthFragment);
                    ft.addToBackStack("Main");
                    ft.commit();
                }else if (position==5){
                    SevenFragment sevenFragment=new SevenFragment();
                    t6=(list1.getItemAtPosition(position)).toString();
                    Bundle b=new Bundle();
                    b.putString("pani",t6);
                    sevenFragment.setArguments(b);
                    FragmentManager fm=getFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.main_layout,sevenFragment);
                    ft.addToBackStack("Main");
                    ft.commit();
                }else if (position==6){
                    EightFragment eightFragment=new EightFragment();
                    t7=(list1.getItemAtPosition(position)).toString();
                    Bundle b=new Bundle();
                    b.putString("yashpal",t7);
                    eightFragment.setArguments(b);
                    FragmentManager fm=getFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.main_layout,eightFragment);
                    ft.addToBackStack("Main");
                    ft.commit();
                }else if (position==7){
                    NineFragment nineFragment=new NineFragment();
                    t8=(list1.getItemAtPosition(position)).toString();
                    Bundle b=new Bundle();
                    b.putString("lal",t8);
                    nineFragment.setArguments(b);
                    FragmentManager fm=getFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.main_layout,nineFragment);
                    ft.addToBackStack("Main");
                    ft.commit();
                }else if (position==8){
                    TenFragment tenFragment=new TenFragment();
                    t9=(list1.getItemAtPosition(position)).toString();
                    Bundle b=new Bundle();
                    b.putString("amrita",t9);
                    tenFragment.setArguments(b);
                    FragmentManager fm=getFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.main_layout,tenFragment);
                    ft.addToBackStack("Main");
                    ft.commit();
                }else if (position==9){
                    ElevenFragment elevenFragment=new ElevenFragment();
                    t10=(list1.getItemAtPosition(position)).toString();
                    Bundle b=new Bundle();
                    b.putString("vishnu",t10);
                    elevenFragment.setArguments(b);
                    FragmentManager fm=getFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.main_layout,elevenFragment);
                    ft.addToBackStack("Main");
                    ft.commit();
                }else{
                    Toast.makeText(getActivity(), "Please click above list", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }

}
