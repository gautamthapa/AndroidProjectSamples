package com.strontech.imgautam.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by imgautam on 19/2/18.
 */

public class MyDatabase extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mydb";

    private static final String TABLE_NAME = "patanjali_store";

    //declare columns...

    private static final String PRODUCT_ID = "id";

    private static final String PRODUCT_NAME = "name";

    private static final String PRODUCT_PRICE = "price";

    //This constructor is used to create Database...it calls the parent constructor
    //context the reference of your activity
    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //create table
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + "(" + PRODUCT_ID + " INTEGER PRIMARY KEY," + PRODUCT_NAME + " TEXT," + PRODUCT_PRICE + " TEXT" + ");";
        //"create table jadu(id primary key,name text,price text); "

        db.execSQL(query);
    }

    //upgrade the table
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addProduct(Product product) {
        SQLiteDatabase database = getWritableDatabase(); //to get authority to write dt

        //to store values
        ContentValues values = new ContentValues();
        values.put(PRODUCT_ID, product.getId());
        values.put(PRODUCT_NAME, product.getName());
        values.put(PRODUCT_PRICE, product.getPrice());

        database.insert(TABLE_NAME, null, values); //null columnHack pass--no inset all the values in table no exception
        database.close();

    }

    public List<Product> getAllProduct() {
        ArrayList<Product> listOfData = new ArrayList<Product>();

        SQLiteDatabase db = getReadableDatabase();


        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);  //point every row--//get the table...

        if (cursor.moveToFirst())   //returns true and false  then it moves first row
        {
            do {
                Product product = new Product();
                product.setId(Integer.parseInt(cursor.getString(0)));
                product.setName(cursor.getString(1));
                product.setPrice(cursor.getString(2));

                listOfData.add(product);

            } while (cursor.moveToNext());
        }
        return listOfData;
    }

    public Product getSingleProduct(int id) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]
                        {PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE},
                PRODUCT_ID + "=?", new String[]{String.valueOf(id)},
                null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Product product = new Product(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));

        return product;
    }

    public int updateProduct(Product product) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PRODUCT_NAME, product.getId());
        values.put(PRODUCT_PRICE, product.getPrice());
        return db.update(TABLE_NAME, values, PRODUCT_ID + "=?"
                , new String[]{String.valueOf(product.getId())});
    }

    public void deleteProduct(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, PRODUCT_ID + "=?", new String[]{String.valueOf(id)});
        db.close();

    }
}
