package com.strontech.imgautam.patanjalistorenew.model;

/**
 * Created by imgautam on 6/3/18.
 */

public class Product {
  private int p_id;
  private String product_name;
  private String product_price;
  private String product_qauntity;
  private String product_desc;

  public Product() {
  }

  public int getP_id() {
    return p_id;
  }

  public void setP_id(int p_id) {
    this.p_id = p_id;
  }

  public String getProduct_name() {
    return product_name;
  }

  public void setProduct_name(String product_name) {
    this.product_name = product_name;
  }

  public String getProduct_price() {
    return product_price;
  }

  public void setProduct_price(String product_price) {
    this.product_price = product_price;
  }

  public String getProduct_qauntity() {
    return product_qauntity;
  }

  public void setProduct_qauntity(String product_qauntity) {
    this.product_qauntity = product_qauntity;
  }

  public String getProduct_desc() {
    return product_desc;
  }

  public void setProduct_desc(String product_desc) {
    this.product_desc = product_desc;
  }
}
