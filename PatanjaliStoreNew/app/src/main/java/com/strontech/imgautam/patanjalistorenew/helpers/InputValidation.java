package com.strontech.imgautam.patanjalistorenew.helpers;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by imgautam on 5/3/18.
 */

public class InputValidation {

  Context context;


  /**
   * constructor
   *
   * @param context
   * */
  public InputValidation(Context context){
    this.context=context;
  }



  /**
   * method to check InputEditText filled
   *
   * @param textInputEditText
   * @param textInputLayout
   * @param message
   * @return
   * */
  public boolean isInputEditTextFilled(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message){
    String value=textInputEditText.getText().toString().trim();
    if (value.isEmpty()){
      textInputLayout.setError(message);
      hideKeyboardFrom(textInputEditText);
      return false;
    }else{
      textInputLayout.setErrorEnabled(false);
    }

    return true;
  }




  /**
   * method to check InputEditTExt has valid email
   *
   * @param textInputEditText
   * @param textInputLayout
   * @param message
   * */
  public boolean isInputEditTextEmail(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message){
    String value = textInputEditText.getText().toString().trim();
    if (value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()){
      textInputLayout.setError(message);
      hideKeyboardFrom(textInputEditText);
      return false;
    }else {
      textInputLayout.setErrorEnabled(false);
    }
    return true;
  }

  public boolean isInputEditTextMatches(TextInputEditText textInputEditText1, TextInputEditText textInputEditText2, TextInputLayout textInputLayout, String message){
    String value1=textInputEditText1.getText().toString().trim();
    String value2=textInputEditText2.getText().toString().trim();
    if (!value1.contentEquals(value2)){
      textInputLayout.setError(message);
      hideKeyboardFrom(textInputEditText2);
      return false;
    }else {
      textInputLayout.setErrorEnabled(false);
    }
    return true;
  }



  /**
   * method to hide keyboard
   *
   * @param view
   * */
  public void hideKeyboardFrom(View view){
    InputMethodManager imm=(InputMethodManager)context.getSystemService(Activity.INPUT_METHOD_SERVICE);
    if (imm != null) {
      imm.hideSoftInputFromWindow(view.getWindowToken(), LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
  }



}
