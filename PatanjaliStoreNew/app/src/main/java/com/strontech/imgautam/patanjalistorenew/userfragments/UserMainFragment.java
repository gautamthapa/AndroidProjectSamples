package com.strontech.imgautam.patanjalistorenew.userfragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import com.strontech.imgautam.patanjalistorenew.R;
import com.strontech.imgautam.patanjalistorenew.adapters.ProductsRecyclerAdapter;
import com.strontech.imgautam.patanjalistorenew.model.Product;
import com.strontech.imgautam.patanjalistorenew.sql.UserDatabaseHelper;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserMainFragment extends Fragment {

  private RecyclerView recyclerViewProducts;
  private List<Product> productList;
  private ProductsRecyclerAdapter productsRecyclerAdapter;
  private UserDatabaseHelper databaseHelper;

  View v;
  public UserMainFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    v= inflater.inflate(R.layout.fragment_user_main, container, false);

//    getActivity().getActionBar().setTitle("");
    initViews();
    initObjects();

    return v;
  }


  /**
   * This method is to initialize views
   */
  private void initViews(){
    recyclerViewProducts=v.findViewById(R.id.recyclerViewProducts);
  }


  /**
   * This method is to initialize objects to be used
   */
  private void initObjects(){

    productList=new ArrayList<>();
    productsRecyclerAdapter=new ProductsRecyclerAdapter(productList);

    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
    recyclerViewProducts.setLayoutManager(layoutManager);
    recyclerViewProducts.setItemAnimator(new DefaultItemAnimator());
    recyclerViewProducts.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    recyclerViewProducts.setHasFixedSize(true);
    recyclerViewProducts.setAdapter(productsRecyclerAdapter);
    databaseHelper=new UserDatabaseHelper(getActivity());

    getDataFromSQLite();

  }


  /**
   * This method is to fetch all products records from SQLite
   */
  private void getDataFromSQLite(){
    // AsyncTask is used that SQLite operation not blocks the UI Thread.
    new AsyncTask<Void, Void, Void>(){

      @Override
      protected Void doInBackground(Void... voids) {
        productList.clear();
        productList.addAll(databaseHelper.getAllProductExceptDesc());

        return null;
      }


      @Override
      protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        productsRecyclerAdapter.notifyDataSetChanged();
      }
    }.execute();
  }



}
