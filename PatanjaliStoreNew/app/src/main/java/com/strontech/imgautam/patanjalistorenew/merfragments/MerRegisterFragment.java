package com.strontech.imgautam.patanjalistorenew.merfragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;
import com.strontech.imgautam.patanjalistorenew.R;
import com.strontech.imgautam.patanjalistorenew.fragments.LoginFragment;
import com.strontech.imgautam.patanjalistorenew.helpers.InputValidation;

/**
 * A simple {@link Fragment} subclass.
 */
public class MerRegisterFragment extends Fragment implements OnClickListener{

  private NestedScrollView nestedScrollView;

  private TextInputEditText textInputEditTextShopId;
  private TextInputEditText textInputEditTextName;
  private TextInputEditText textInputEditTextMobNumber;
  private TextInputEditText textInputEditTextEmail;
  private TextInputEditText textInputEditTextAddress;

  private TextInputLayout textInputLayoutShopId;
  private TextInputLayout textInputLayoutName;
  private TextInputLayout textInputLayoutMobNumber;
  private TextInputLayout textInputLayoutEmail;
  private TextInputLayout textInputLayoutAddress;

  private Button buttonSubmit;
  private TextView textViewLoginLink;

  public String FILE="myFile";
  private String mShop_id, mName, mMob, mEmail, mAdd;

  private InputValidation inputValidation;
  SharedPreferences preferences;
  SharedPreferences.Editor editor;

  private View v;
  public MerRegisterFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    v= inflater.inflate(R.layout.fragment_mer_register, container, false);

    initViews();
    initListener();
    initObjects();

    return v;
  }

  /**
   * This method is to initialize views
   */
  private void initViews() {

    nestedScrollView=v.findViewById(R.id.nestedScrollView);

    textInputLayoutShopId=v.findViewById(R.id.textInputLayoutShopId);
    textInputLayoutName=v.findViewById(R.id.textInputLayoutName);
    textInputLayoutMobNumber=v.findViewById(R.id.textInputLayoutMobNumber);
    textInputLayoutEmail=v.findViewById(R.id.textInputLayoutEmail);
    textInputLayoutAddress=v.findViewById(R.id.textInputLayoutShopAddress);

    textInputEditTextShopId=v.findViewById(R.id.edt_shopid_mer);
    textInputEditTextName=v.findViewById(R.id.edt_username_mer);
    textInputEditTextMobNumber=v.findViewById(R.id.edt_mob_mer);
    textInputEditTextEmail=v.findViewById(R.id.edt_email_mer);
    textInputEditTextAddress=v.findViewById(R.id.edt_address_mer);

    buttonSubmit=v.findViewById(R.id.btn_reg_mer);
    textViewLoginLink=v.findViewById(R.id.textViewLoginLink);

  }


  /**
   * This method is to initialize listeners
   */
  private void initListener(){
    buttonSubmit.setOnClickListener(this);
    textViewLoginLink.setOnClickListener(this);
  }


  /**
   * This method is to initialize objects to be used
   */
  private void initObjects(){
    inputValidation=new InputValidation(getActivity());
    preferences=this.getActivity().getSharedPreferences(FILE, Context.MODE_PRIVATE);
    editor=preferences.edit();
  }




  /**
   * This implemented method is to listen the click on view
   *
   * @param v
   */
  @Override
  public void onClick(View v) {
    switch (v.getId()){
      case R.id.btn_reg_mer:
        postDataToSharedPreferences();
        break;
      case R.id.textViewLoginLink:
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.first_layout, new LoginFragment());
        ft.commit();
        break;
    }
  }


  /**
   * This method is to validate the input text fields and post data to SharedPreferences
   */
  private void postDataToSharedPreferences(){

    if (!inputValidation.isInputEditTextFilled(textInputEditTextShopId, textInputLayoutShopId, "Please enter shopId")){
      return;
    }
    if (!inputValidation.isInputEditTextFilled(textInputEditTextName, textInputLayoutName, "Please enter your name")){
      return;
    }
    if (!inputValidation.isInputEditTextFilled(textInputEditTextMobNumber, textInputLayoutMobNumber, "Please enter valid Mobile number.")){
      return;
    }
    if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, "Please enter valid email")){
      return;
    }
    if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, "Please enter valid email.")){
      return;
    }
    if (!inputValidation.isInputEditTextFilled(textInputEditTextAddress, textInputLayoutAddress, "Please enter Shop Address.")){
      return;
    }

    editor.putString("email",textInputEditTextEmail.getText().toString().trim());
    editor.putString("mob_number", textInputEditTextMobNumber.getText().toString().trim());
    editor.commit();

    Snackbar.make(nestedScrollView,"Successfully registered.",Snackbar.LENGTH_LONG).show();
    emptyInputEditText();
  }




  /**
   * This method is to empty all input edit text
   */
  private void emptyInputEditText() {
    textInputEditTextShopId.setText(null);
    textInputEditTextName.setText(null);
    textInputEditTextMobNumber.setText(null);
    textInputEditTextEmail.setText(null);
    textInputEditTextAddress.setText(null);
  }
}
