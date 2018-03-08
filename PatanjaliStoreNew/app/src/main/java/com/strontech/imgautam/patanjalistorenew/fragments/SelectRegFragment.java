package com.strontech.imgautam.patanjalistorenew.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.LinearLayout;
import com.strontech.imgautam.patanjalistorenew.R;
import com.strontech.imgautam.patanjalistorenew.merfragments.MerRegisterFragment;
import com.strontech.imgautam.patanjalistorenew.userfragments.UserRegisterFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectRegFragment extends Fragment implements OnClickListener{


  private AppCompatButton userButton_Reg, merButtonReg;
  private CardView userRegCard, merRegCard;

  private View v;

  public SelectRegFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    v= inflater.inflate(R.layout.fragment_select_reg, container, false);

    userButton_Reg=v.findViewById(R.id.btn_Uregister);
    merButtonReg=v.findViewById(R.id.btn_Mregister);
    userRegCard=v.findViewById(R.id.cardView1);
    merRegCard=v.findViewById(R.id.cardView2);

    initViews();
    initListeners();


    return v;
  }



  /**
   * This method is to initialize views
   * */
  private void initViews(){

    userButton_Reg=v.findViewById(R.id.btn_Uregister);
    merButtonReg=v.findViewById(R.id.btn_Mregister);
    userRegCard=v.findViewById(R.id.cardView1);
    merRegCard=v.findViewById(R.id.cardView2);

  }


  /**
   * This method is to initialize listeners
   * */
  private void initListeners(){
    userButton_Reg.setOnClickListener(this);
    merButtonReg.setOnClickListener(this);
  }


  /**
   * This implemented method is to listen the click on view
   *
   * @param v
   */
  @Override
  public void onClick(View v) {

    switch (v.getId()){

      case R.id.btn_Uregister:
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.first_layout, new UserRegisterFragment());
        ft.addToBackStack("SelectRegister");
        ft.commit();
        break;
      case R.id.btn_Mregister:
        FragmentTransaction ft1=getFragmentManager().beginTransaction();
        ft1.replace(R.id.first_layout, new MerRegisterFragment());
        ft1.addToBackStack("SelectRegister");
        ft1.commit();
        break;
    }

  }
}
