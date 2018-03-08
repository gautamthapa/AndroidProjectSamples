package com.strontech.imgautam.patanjalistorenew.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.strontech.imgautam.patanjalistorenew.R;
import com.strontech.imgautam.patanjalistorenew.model.Product;
import java.util.List;

/**
 * Created by imgautam on 6/3/18.
 */

public class ProductsRecyclerAdapter extends RecyclerView.Adapter<ProductsRecyclerAdapter.ProductViewHolder> {

  private List<Product> productList;


  //make constructor
  public ProductsRecyclerAdapter(List<Product> productList){
    this.productList=productList;
  }

  @Override
  public ProductViewHolder onCreateViewHolder(ViewGroup parent,
      int viewType) {

    //inflate the recycler item view

    View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_recycler,parent,false);


    return new ProductViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(ProductViewHolder holder, int position) {

    //set the products
    holder.textViewProductName.setText(productList.get(position).getProduct_name());
    holder.textViewProductQuantity.setText(productList.get(position).getProduct_qauntity());
    holder.textViewProductPrice.setText("Rs. "+productList.get(position).getProduct_price());
  }

  @Override
  public int getItemCount() {

    Log.v(ProductsRecyclerAdapter.class.getSimpleName(),""+productList.size());
    return productList.size();
  }


  /**
   * ViewHolder class
   * */
  class ProductViewHolder extends RecyclerView.ViewHolder{

    //public ImageView imageViewProductImage;

    public TextView textViewProductName;
    public TextView textViewProductQuantity;
    public TextView textViewProductPrice;

    public ProductViewHolder(View itemView) {
      super(itemView);

      textViewProductName=itemView.findViewById(R.id.textViewProductName);
      textViewProductQuantity=itemView.findViewById(R.id.textViewProductQuantity);
      textViewProductPrice=itemView.findViewById(R.id.textViewProductPrice);
    }
  }
}
