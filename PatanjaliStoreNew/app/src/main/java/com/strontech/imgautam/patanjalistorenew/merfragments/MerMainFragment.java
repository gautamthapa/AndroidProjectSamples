package com.strontech.imgautam.patanjalistorenew.merfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.strontech.imgautam.patanjalistorenew.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MerMainFragment extends Fragment implements OnClickListener {

  private CardView cardViewAddProduct;
  private CardView cardViewUpdateProduct;
  private CardView cardViewShowProduct;
  private CardView cardViewDeleteProduct;

  private View v;

  public MerMainFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    v = inflater.inflate(R.layout.fragment_mer_main, container, false);

    initViews();
    initListeners();


    return v;
  }

  /**
   * this method is to initialize Views
   * */
  private void initViews(){
    cardViewAddProduct=v.findViewById(R.id.cardViewAddProduct);
    cardViewUpdateProduct=v.findViewById(R.id.cardViewUpdateProduct);
    cardViewShowProduct=v.findViewById(R.id.cardViewShowProduct);
    cardViewDeleteProduct=v.findViewById(R.id.cardViewDeleteProduct);
  }

  /**
   * this method is to initialize Listeners
   * */
  private void initListeners(){
    cardViewAddProduct.setOnClickListener(this);
    cardViewUpdateProduct.setOnClickListener(this);
    cardViewShowProduct.setOnClickListener(this);
    cardViewDeleteProduct.setOnClickListener(this);
  }
  @Override
  public void onClick(View v) {
    switch (v.getId()){
      case R.id.cardViewAddProduct:
        FragmentTransaction ft1=getFragmentManager().beginTransaction();
        ft1.replace(R.id.first_layout, new AddProductFragment());
        ft1.addToBackStack("MerMainFragment");
        ft1.commit();
        break;
      case R.id.cardViewUpdateProduct:
        FragmentTransaction ft2=getFragmentManager().beginTransaction();
        ft2.replace(R.id.first_layout, new UpdateProductFragment());
        ft2.addToBackStack("MerMainFragment");
        ft2.commit();
        break;
      case R.id.cardViewShowProduct:
        FragmentTransaction ft3=getFragmentManager().beginTransaction();
        ft3.replace(R.id.first_layout, new ShowProductFragment());
        ft3.addToBackStack("MerMainFragment");
        ft3.commit();
        break;
      case R.id.cardViewDeleteProduct:
        FragmentTransaction ft4=getFragmentManager().beginTransaction();
        ft4.replace(R.id.first_layout, new DeleteProductFragment());
        ft4.addToBackStack("MerMainFragment");
        ft4.commit();
        break;
    }
  }
}
