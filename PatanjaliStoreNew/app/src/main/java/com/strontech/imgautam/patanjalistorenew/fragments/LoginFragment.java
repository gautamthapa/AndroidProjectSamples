package com.strontech.imgautam.patanjalistorenew.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;
import com.strontech.imgautam.patanjalistorenew.R;
import com.strontech.imgautam.patanjalistorenew.activities.FirstActivity;
import com.strontech.imgautam.patanjalistorenew.helpers.InputValidation;
import com.strontech.imgautam.patanjalistorenew.merfragments.MerMainFragment;
import com.strontech.imgautam.patanjalistorenew.sql.UserDatabaseHelper;
import com.strontech.imgautam.patanjalistorenew.userfragments.UserMainFragment;
import com.strontech.imgautam.patanjalistorenew.userfragments.UserRegisterFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

  //private final AppCompatActivity activity=FirstActivity.this;
  //private Context context;


  private NestedScrollView nestedScrollView;

  private TextInputLayout textInputLayoutEmail;
  private TextInputLayout textInputLayoutPassword;

  private TextInputEditText textInputEditTextEmail;
  private TextInputEditText textInputEditTextPassword;

  private AppCompatButton appCompatButtonLogin;

  private AppCompatTextView textViewLinkRegister;

  private InputValidation inputValidation;
  private UserDatabaseHelper userDatabaseHelper;

  private String getEmailFromPref, getGetPassFromPref;
  SharedPreferences preferences;


  private View v;

  public LoginFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    // Inflate the layout for this fragment
    v = inflater.inflate(R.layout.fragment_login, container, false);

    initViews();
    initListeners();
    initObjects();

    return v;
  }


  /**
   * this method is to initialize views
   */
  private void initViews() {

    nestedScrollView = v.findViewById(R.id.nestedScrollView);

    textInputLayoutEmail = v.findViewById(R.id.textInputLayoutEmail);
    textInputLayoutPassword = v.findViewById(R.id.textInputLayoutPassword);

    textInputEditTextEmail = v.findViewById(R.id.textInputEditTextEmail);
    textInputEditTextPassword = v.findViewById(R.id.textInputEditTexPassword);

    appCompatButtonLogin = v.findViewById(R.id.appCompatButtonLogin);

    textViewLinkRegister = v.findViewById(R.id.textViewLinkRegister);
  }


  /**
   * this method is to initialize listeners
   */
  private void initListeners() {
    appCompatButtonLogin.setOnClickListener(this);
    textViewLinkRegister.setOnClickListener(this);
  }


  /**
   * this method is used to initialize Objects
   */
  private void initObjects() {
    userDatabaseHelper = new UserDatabaseHelper(getActivity());
    inputValidation = new InputValidation(getActivity());

    preferences = this.getActivity().getSharedPreferences("myFile", Context.MODE_PRIVATE);

    Toast.makeText(getActivity(), "" + inputValidation, Toast.LENGTH_LONG).show();
  }


  /**
   * this implemented method is to listen the click on view
   */
  @Override
  public void onClick(View v) {

    switch (v.getId()) {
      case R.id.appCompatButtonLogin:
        verifyFromSQLite();
        break;
      case R.id.textViewLinkRegister:
        //Navigate to RegisterFragment
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.first_layout, new SelectRegFragment());
        ft.commit();
        break;
    }
  }


  /**
   * this method is used to validate the input text fields and verify login credentials from SQLite
   */
  private void verifyFromSQLite() {

    if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail,
        getString(R.string.error_message_email))) {
      return;
    }
    if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail,
        getString(R.string.error_message_email))) {
      return;
    }
    if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword,
        getString(R.string.error_message_email))) {
      return;
    }

    //data get from SharedPreferences
    getEmailFromPref = preferences.getString("email", null);
    getGetPassFromPref = preferences.getString("mob_number", null);



    //check input data is available or not in SharedPreferences
    boolean yes = getEmailFromPref.contentEquals(textInputEditTextEmail.getText().toString().trim())
        && getGetPassFromPref.contentEquals(textInputEditTextPassword.getText().toString().trim());


    if (userDatabaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim(),
        textInputEditTextPassword.getText().toString().trim())) {
      FragmentTransaction ft = getFragmentManager().beginTransaction();
      ft.replace(R.id.first_layout, new UserMainFragment());
      emptyInputEditText();
      ft.commit();

      /**
       * data send
       * */
    } else if (yes) {
      FragmentTransaction ft1 = getFragmentManager().beginTransaction();
      ft1.replace(R.id.first_layout, new MerMainFragment());
      ft1.commit();
      emptyInputEditText();

      Snackbar.make(nestedScrollView, "Successfully logged in", Snackbar.LENGTH_LONG).show();

    } else {

      //snack Bar to show success message that record os wrong
      Snackbar.make(nestedScrollView, getString(R.string.error_valid_email_password),
          Snackbar.LENGTH_LONG).show();
    }
  }


  /**
   * this method is to empty all the editText
   */
  private void emptyInputEditText() {
    textInputEditTextEmail.setText(null);
    textInputEditTextPassword.setText(null);
  }
}
