package com.strontech.imgautam.patanjalistorenew.userfragments;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.strontech.imgautam.patanjalistorenew.R;
import com.strontech.imgautam.patanjalistorenew.fragments.LoginFragment;
import com.strontech.imgautam.patanjalistorenew.helpers.InputValidation;
import com.strontech.imgautam.patanjalistorenew.model.UserInfo;
import com.strontech.imgautam.patanjalistorenew.sql.UserDatabaseHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserRegisterFragment extends Fragment implements OnClickListener {

  private LinearLayout linearLayout;

  private TextInputLayout textInputLayoutUserName;
  private TextInputLayout textInputLayoutUserEmail;
  private TextInputLayout textInputLayoutUserPassword;
  private TextInputLayout textInputLayoutUserConfirmPassword;
  private TextInputLayout textInputLayoutUserMobNumber;
  private TextInputLayout textInputLayoutUserAddress;

  private TextInputEditText textInputEditTextUserName;
  private TextInputEditText textInputEditTextUserEmail;
  private TextInputEditText textInputEditTextUserPassword;
  private TextInputEditText textInputEditTextUserConfirmPassword;
  private TextInputEditText textInputEditTextUserMobNumber;
  private TextInputEditText textInputEditTextUserAddress;

  private Button buttonRegisterUser;
  private TextView textViewLoginLink;

  private InputValidation inputValidation;
  private UserDatabaseHelper databaseHelper;
  private UserInfo userInfo;

  private View v;

  public UserRegisterFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    v = inflater.inflate(R.layout.fragment_user_register, container, false);

    initViews();
    initListeners();
    initObjects();

    return v;
  }


  /**
   * This method is to initialize views
   */
  private void initViews() {
    linearLayout = v.findViewById(R.id.linearLayout);

    textInputLayoutUserName = v.findViewById(R.id.textInputLayoutUserName);
    textInputLayoutUserEmail = v.findViewById(R.id.textInputLayoutUserEmail);
    textInputLayoutUserPassword=v.findViewById(R.id.textInputLayoutUserPassword);
    textInputLayoutUserConfirmPassword=v.findViewById(R.id.textInputLayoutUserConfirmPassword);
    textInputLayoutUserMobNumber = v.findViewById(R.id.textInputLayoutUserMobNumber);
    textInputLayoutUserAddress = v.findViewById(R.id.textInputLayoutUserAddress);

    textInputEditTextUserName = v.findViewById(R.id.textInputEditTextUserName);
    textInputEditTextUserEmail = v.findViewById(R.id.textInputEditTextUserEmail);
    textInputEditTextUserPassword =v.findViewById(R.id.textInputEditTextUserPassword);
    textInputEditTextUserConfirmPassword =v.findViewById(R.id.textInputEditTextUserConfirmPassword);
    textInputEditTextUserMobNumber = v.findViewById(R.id.textInputEditTextUserMobNumber);
    textInputEditTextUserAddress = v.findViewById(R.id.textInputEditTextUserAddress);

    buttonRegisterUser = v.findViewById(R.id.buttonRegisterUser);

    textViewLoginLink = v.findViewById(R.id.textViewLoginLink);
  }


  /**
   * This method is to initialize listeners
   */
  private void initListeners() {
    buttonRegisterUser.setOnClickListener(this);
    textViewLoginLink.setOnClickListener(this);
  }


  /**
   * This method is to initialize objects to be used
   */
  private void initObjects() {
    inputValidation = new InputValidation(getActivity());
    databaseHelper = new UserDatabaseHelper(getActivity());
    userInfo = new UserInfo();
  }


  /**
   * This implemented method is to listen the click on view
   */
  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.buttonRegisterUser:
        postDataToSQLite();
        break;
      case R.id.textViewLoginLink:
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.first_layout, new LoginFragment());
        ft.commit();
        break;
    }
  }


  /**
   * This method is to validate the input text fields and post data to SQLite
   */
  private void postDataToSQLite() {
    if (!inputValidation.isInputEditTextFilled(textInputEditTextUserName, textInputLayoutUserName,
        "Please enter full name")) {
      return;
    }
    if (!inputValidation.isInputEditTextFilled(textInputEditTextUserEmail, textInputLayoutUserEmail,
        "Please enter valid email")) {
      return;
    }
    if (!inputValidation.isInputEditTextEmail(textInputEditTextUserEmail, textInputLayoutUserEmail,
        "Please enter valid email")) {
      return;
    }
    if (!inputValidation.isInputEditTextFilled(textInputEditTextUserPassword, textInputLayoutUserPassword, "Please enter password")){
      return;
    }
    if (!inputValidation.isInputEditTextMatches(textInputEditTextUserPassword, textInputEditTextUserConfirmPassword, textInputLayoutUserConfirmPassword, "Password Does Not Matches")){
      return;
    }
    if (!inputValidation
        .isInputEditTextFilled(textInputEditTextUserMobNumber, textInputLayoutUserMobNumber,
            "Please enter valid mobile number")) {
      return;
    }
    if (!inputValidation
        .isInputEditTextFilled(textInputEditTextUserAddress, textInputLayoutUserAddress,
            "Please enter full delivery address")) {
      return;
    }

    if (!databaseHelper.checkUser(textInputEditTextUserEmail.getText().toString().trim())) {

      userInfo.setUsername(textInputEditTextUserName.getText().toString().trim());
      userInfo.setEmail(textInputEditTextUserEmail.getText().toString().trim());
      userInfo.setPassword(textInputEditTextUserPassword.getText().toString().trim());
      userInfo.setMob_number(textInputEditTextUserMobNumber.getText().toString().trim());
      userInfo.setAddress(textInputEditTextUserAddress.getText().toString().trim());

      databaseHelper.addUser(userInfo);

      // Snack Bar to show success message that record saved successfully
      Snackbar.make(linearLayout, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
      emptyInputEditText();

    } else {

      // Snack Bar to show error message that record already exists
      Snackbar.make(linearLayout, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG)
          .show();
    }
  }


  /**
   * This method is to empty all input edit text
   */
  private void emptyInputEditText() {
    textInputEditTextUserName.setText(null);
    textInputEditTextUserMobNumber.setText(null);
    textInputEditTextUserEmail.setText(null);
    textInputEditTextUserAddress.setText(null);
  }
}
