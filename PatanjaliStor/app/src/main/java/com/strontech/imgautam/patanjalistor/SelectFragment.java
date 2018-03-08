package com.strontech.imgautam.patanjalistor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectFragment extends Fragment {


    private Button btn1, btn2;
    private CardView card1, card2;
    private LinearLayout li1, li2;

    public SelectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_select, container, false);
        btn1=v.findViewById(R.id.btn_Uregister);
        btn2=v.findViewById(R.id.btn_Mregister);
        card1=v.findViewById(R.id.cardView1);
        card2=v.findViewById(R.id.cardView2);

        li1=v.findViewById(R.id.user_layout);
        li2=v.findViewById(R.id.merch_layout);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft=getFragmentManager().beginTransaction();
                ft.replace(R.id.main_layout,new UserSignupFragment());
                ft.addToBackStack("selectFragment");
                ft.commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft=getFragmentManager().beginTransaction();
                ft.replace(R.id.main_layout,new MerchSignupFragment());
                ft.addToBackStack("selectFragment");
                ft.commit();
            }
        });
        return v;
    }


}
