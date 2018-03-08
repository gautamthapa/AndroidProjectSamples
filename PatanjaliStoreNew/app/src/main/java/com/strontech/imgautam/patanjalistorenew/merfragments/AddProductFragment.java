package com.strontech.imgautam.patanjalistorenew.merfragments;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.LinearLayout;
import com.strontech.imgautam.patanjalistorenew.R;
import com.strontech.imgautam.patanjalistorenew.helpers.InputValidation;
import com.strontech.imgautam.patanjalistorenew.model.Product;
import com.strontech.imgautam.patanjalistorenew.sql.UserDatabaseHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddProductFragment extends Fragment implements OnClickListener{

  private LinearLayout linearLayout;

  private TextInputLayout textInputLayoutProductName;
  private TextInputLayout textInputLayoutProductPrice;
  private TextInputLayout textInputLayoutProductQuantity;
  private TextInputLayout textInputLayoutProductDesc;

  private TextInputEditText textInputTextProductName;
  private TextInputEditText textInputTextProductPrice;
  private TextInputEditText textInputTextProductQuantity;
  private TextInputEditText textInputTextProductDesc;

  private Button buttonAddProduct;

  private InputValidation inputValidation;
  private UserDatabaseHelper databaseHelper;
  private Product product;

  private View v;

  public AddProductFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    v= inflater.inflate(R.layout.fragment_add_product, container, false);

    initViews();
    initListeners();
    initObjects();

    return v;
  }


  /**
   * This method is to initialize views
   */
  private void initViews(){
    linearLayout=v.findViewById(R.id.linearLayout);

    textInputLayoutProductName=v.findViewById(R.id.textInputLayoutProductName);
    textInputLayoutProductPrice=v.findViewById(R.id.textInputLayoutProductPrice);
    textInputLayoutProductQuantity=v.findViewById(R.id.textInputLayoutProductQuantity);
    textInputLayoutProductDesc=v.findViewById(R.id.textInputLayoutProductDesc);

    textInputTextProductName=v.findViewById(R.id.textInputTextProductName);
    textInputTextProductPrice=v.findViewById(R.id.textInputTextProductPrice);
    textInputTextProductQuantity=v.findViewById(R.id.textInputTextProductQuantity);
    textInputTextProductDesc=v.findViewById(R.id.textInputTextProductDesc);

    buttonAddProduct=v.findViewById(R.id.buttonAddProduct);
  }


  /**
  * This method is to initialize listeners
  */
  private void initListeners(){
    buttonAddProduct.setOnClickListener(this);
  }



  /**
   * This method is to initialize objects to be used
   */
  private void initObjects()
  {
    inputValidation=new InputValidation(getActivity());
    databaseHelper=new UserDatabaseHelper(getActivity());
    product=new Product();
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()){
      case R.id.buttonAddProduct:
        postDataToSQLite();
        break;
    }
  }


  /**
   * This method is to validate the input text fields and post data to SQLite
   */
  private void postDataToSQLite(){
    if (!inputValidation.isInputEditTextFilled(textInputTextProductName, textInputLayoutProductName, "Please enter Product Name")){
      return;
    }
    if (!inputValidation.isInputEditTextFilled(textInputTextProductPrice, textInputLayoutProductPrice, "Please enter Product Price")){
      return;
    }
    if (!inputValidation.isInputEditTextFilled(textInputTextProductQuantity, textInputLayoutProductQuantity, "Please enter Product Quantity")){
      return;
    }
    if (!inputValidation.isInputEditTextFilled(textInputTextProductDesc, textInputLayoutProductQuantity, "Please enter Product Description")){
      return;
    }

    product.setProduct_name(textInputTextProductName.getText().toString().trim());
    product.setProduct_price(textInputTextProductPrice.getText().toString().trim());
    product.setProduct_qauntity(textInputTextProductQuantity.getText().toString().trim());
    product.setProduct_desc(textInputTextProductDesc.getText().toString().trim());
    databaseHelper.addProduct(product);

    // Snack Bar to show success message that record saved successfully
    Snackbar.make(linearLayout, "Product added successfully.", Snackbar.LENGTH_LONG).show();
    emptyInputEditText();
  }


  /**
   * This method is to empty all input edit text
   */
  private void emptyInputEditText(){
    textInputTextProductName.setText(null);
    textInputTextProductPrice.setText(null);
    textInputTextProductQuantity.setText(null);
    textInputTextProductDesc.setText(null);
  }
}
