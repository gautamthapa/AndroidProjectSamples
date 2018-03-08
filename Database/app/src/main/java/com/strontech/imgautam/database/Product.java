package com.strontech.imgautam.database;

/**
 * Created by imgautam on 20/2/18.
 */

//pojo class  to get and set value
public class Product {

    int id;
    String name, price;

    //default constructor  make object of this class without passing arguments of this class constructor
    public Product()
    {

    }


    //pameterised cons
    public Product(int id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
