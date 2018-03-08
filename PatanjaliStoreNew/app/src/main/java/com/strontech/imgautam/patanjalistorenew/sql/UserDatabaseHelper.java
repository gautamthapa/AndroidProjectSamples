package com.strontech.imgautam.patanjalistorenew.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;
import com.strontech.imgautam.patanjalistorenew.model.Product;
import com.strontech.imgautam.patanjalistorenew.model.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imgautam on 4/3/18.
 */

public class UserDatabaseHelper extends SQLiteOpenHelper {

  //Define DB schema
  private static final String DATABASE_NAME = "userManager";
  private static final int DATABASE_VERSION = 1;
  private static final String TABLE_USER = "user";


  //Columns
  private static final String COLUMN_UID = "user_id";
  private static final String COLUMN_USER_NAME = "user_name";
  private static final String COLUMN_USER_EMAIL = "user_email";
  private static final String COLUMN_USER_PASSWORD = "user_password";
  private static final String COLUMN_USER_MOB_NUMBER = "user_mob_number";
  private static final String COLUMN_USER_ADDRESS = "user_address";

  //products table
  private static final String TABLE_PRODUCT = "product";

  //products table columns
  private static final String COLUMN_PID = "product_id";
  private static final String COLUMN_PRODUCT_NAME = "product_name";
  private static final String COLUMN_PRODUCT_PRICE = "product_price";
  private static final String COLUMN_PRODUCT_QUANTITY = "product_quantity";
  private static final String COLUMN_PRODUCT_DESC = "product_desc";

  //create user_table query
  private static final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + " ("
      + COLUMN_UID + " INTEGER PRIMARY KEY, " + COLUMN_USER_NAME
      + " TEXT, " + COLUMN_USER_EMAIL + " TEXT, " + COLUMN_USER_PASSWORD
      + " TEXT, " + COLUMN_USER_MOB_NUMBER + " TEXT, " + COLUMN_USER_ADDRESS + " TEXT);";

  //drop user_table query
  private static final String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

  //create product_table query
  private static final String CREATE_PRODUCT_TABLE = "CREATE TABLE " + TABLE_PRODUCT + " ("
      + COLUMN_PID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PRODUCT_NAME
      + " TEXT, " + COLUMN_PRODUCT_PRICE + " TEXT, " + COLUMN_PRODUCT_QUANTITY
      + " TEXT, " + COLUMN_PRODUCT_DESC + " TEXT);";

  //drop product_table query
  private static final String DROP_PRODUCT_TABLE = "DROP TABLE IF EXISTS " + TABLE_PRODUCT;


  private Context context;

  /**
   * Constructor
   */
  public UserDatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    try {

      db.execSQL(CREATE_USER_TABLE);
      db.execSQL(CREATE_PRODUCT_TABLE);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    try {

      db.execSQL(DROP_USER_TABLE);
      db.execSQL(DROP_PRODUCT_TABLE);

      //create new table
      onCreate(db);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  /**
   * This method is used to create a user record
   *
   * @params user
   */
  public void addUser(UserInfo user) {

    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(COLUMN_USER_NAME, user.getUsername());
    values.put(COLUMN_USER_EMAIL, user.getEmail());
    values.put(COLUMN_USER_PASSWORD, user.getPassword());
    values.put(COLUMN_USER_MOB_NUMBER, user.getMob_number());
    values.put(COLUMN_USER_ADDRESS, user.getAddress());

    //inserting the row
    db.insert(TABLE_USER, null, values);
    db.close();
  }

  /**
   * this method is used to fetch all user and return the list of user records
   *
   * @return list
   */
  public List<UserInfo> getAllUser() {

    //array of columns to fetch
    String[] columns = {
        COLUMN_UID,
        COLUMN_USER_NAME,
        COLUMN_USER_EMAIL,
        COLUMN_USER_PASSWORD,
        COLUMN_USER_MOB_NUMBER,
        COLUMN_USER_ADDRESS
    };

    //sorting orders
    String sortOrder =
        COLUMN_USER_NAME + " ASC";

    List<UserInfo> userList = new ArrayList<UserInfo>();

    SQLiteDatabase db = this.getReadableDatabase();

    /**
     * query the user table
     *
     * Here query function is used to fetch the records of user table, this function works like
     * we user sql query.
     *
     * SQL query equivalent to this query function is
     * SELECT user_id, user_name, user_password, user_mob_number, user_email, user_address from user ORDER BY user_name;
     *
     * */
    Cursor cursor = db.query(TABLE_USER,  //  TABLE to query
        columns,                    //columns to return
        null,                       //columns for the where clause
        null,                    //the values for the where clause
        null,                       //group the rows
        null,                        //filter by the row groups
        sortOrder                           //sort the order
    );

    //Traversing through all the rows and adding to list
    if (cursor.moveToFirst()) {
      do {
        UserInfo user = new UserInfo();
        user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_UID))));
        user.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
        user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
        user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
        user.setMob_number(cursor.getString(cursor.getColumnIndex(COLUMN_USER_MOB_NUMBER)));
        user.setAddress(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ADDRESS)));

        //adding user record to list
        userList.add(user);
      } while (cursor.moveToNext());

      cursor.close();
      db.close();
    }
    return userList;
  }


  /**
   * this method to update user record
   *
   * @params UserInfo
   */
  public void updateUser(UserInfo user) {

    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(COLUMN_USER_NAME, user.getUsername());
    values.put(COLUMN_USER_EMAIL, user.getEmail());
    values.put(COLUMN_USER_PASSWORD, user.getPassword());
    values.put(COLUMN_USER_MOB_NUMBER, user.getMob_number());
    values.put(COLUMN_USER_ADDRESS, user.getAddress());

    //updating the row;
    db.update(TABLE_USER, values, COLUMN_UID + " = ?",
        new String[]{String.valueOf(user.getId())});
    db.close();
  }


  /**
   * This method is to delete to user record
   *
   * @params user
   */
  public void deleteUser(UserInfo user) {

    SQLiteDatabase db = this.getWritableDatabase();

    //delete user record by id
    db.delete(TABLE_USER, COLUMN_UID + " = ?",
        new String[]{String.valueOf(user.getId())});
    db.close();
  }

  /**
   * This method to check user exist or not
   *
   * @return true/false
   */
  public boolean checkUser(String email) {

    //array of column to fetch
    String[] columns = {
        COLUMN_UID
    };

    SQLiteDatabase db = this.getReadableDatabase();

    //selection criteria
    String selection = COLUMN_USER_EMAIL + " = ?";

    //selection argument
    String[] selectionArgs = {email};

    //query user table with condition
    /**
     * Here query function is used to fetch records from user table this function works like we use sql query
     * SQL query equivalent to this query function is
     * SELECT user_id FROM user WHERE user_email = 'gautam.thapa22@gmail.com';
     * */
    Cursor cursor = db.query(TABLE_USER, //Table to query
        columns,                    //columns to return
        selection,                //columns for the WHERE clause
        selectionArgs,              //The values for the WHERE clause
        null,                       //group of the rows
        null,                   //filter by row groups
        null                    //the sort order
    );

    int cursorCount = cursor.getCount();
    cursor.close();
    db.close();

    if (cursorCount > 0) {
      return true;
    }

    return false;
  }


  /**
   * This method is to check user exist or not
   *
   * @return true/false
   */
  public boolean checkUser(String email, String password) {

    //array of columns to fetch
    String[] columns = {
        COLUMN_UID
    };

    SQLiteDatabase db = this.getReadableDatabase();
    if (db == null) {
      Log.d("DB", "No database");
    }
    //selection criteria
    String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

    //selection arguments
    String[] selectionArgs = {email, password};

    //query user table with conditions
    /**
     * Here query function is used to fetch records from user table this function works like we use sql query.
     * SQL query is equivalent to this query function is
     * SELECT user_id FROM user WHERE user_email = 'gautam.thapa22@gmail.com' AND user_password = '12345678';
     * */
    Cursor cursor = db.query(TABLE_USER,  //Table to query
        columns,                    //columns to return
        selection,                  //columns for the WHERE clause
        selectionArgs,              //The values for the WHERE clause
        null,                       //group the rows
        null,                       //filter by the row groups
        null                     //The sort order
    );

    int cursorCount = cursor.getCount();

    cursor.close();
    db.close();
    if (cursorCount > 0) {
      return true;
    }

    return false;
  }


  /**
   * *************************** Products *****************************************
   *
   * this method is to create product record
   */
  public void addProduct(Product product) {
    SQLiteDatabase db = getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(COLUMN_PRODUCT_NAME, product.getProduct_name());
    values.put(COLUMN_PRODUCT_PRICE, product.getProduct_price());
    values.put(COLUMN_PRODUCT_QUANTITY, product.getProduct_qauntity());
    values.put(COLUMN_PRODUCT_DESC, product.getProduct_desc());

    //Inserting Row
    db.insert(TABLE_PRODUCT, null, values);
    db.close();
  }

  /**
   * This method is to fetch all product and return the list of user records
   *
   * @return list
   */
  public List<Product> getAllProducts() {
    //array of column to fetch
    String[] columns = {
        COLUMN_PID,
        COLUMN_PRODUCT_NAME,
        COLUMN_PRODUCT_PRICE,
        COLUMN_PRODUCT_QUANTITY,
        COLUMN_PRODUCT_DESC
    };

    //sorting orders
    String sortOrder =
        COLUMN_PRODUCT_NAME + " ASC";

    List<Product> productList = new ArrayList<Product>();

    SQLiteDatabase db = this.getReadableDatabase();

    //query the product table
    /**
     * Here query function is used to fetch records from user table this function works like we use sql query.
     * SQL query equivalent to this query function is
     * SELECT p_id,product_name,product_price,product_quantity FROM product ORDER BY product_name;
     */
    Cursor cursor = db.query(TABLE_PRODUCT, //Table to query
        columns,              //columns to return
        null,        //columns for the WHERE clause
        null,     //The values for the WHERE clause
        null,         //group the rows
        null,         //filter by row groups
        sortOrder);         //The sort order

    //Traversing all the rows and add to list
    if (cursor.moveToFirst()) {
      do {
        Product product = new Product();
        product.setP_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_PID))));
        product.setProduct_name(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_NAME)));
        product.setProduct_price(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_PRICE)));
        product
            .setProduct_qauntity(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_QUANTITY)));
        product.setProduct_desc(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_DESC)));

        //adding product record to list
        productList.add(product);
      } while (cursor.moveToNext());
    }
    cursor.close();
    db.close();

    //return product list
    return productList;
  }




  /**
   * This method is to fetch all product except Description and return the list of user records
   *
   * @return list
   */
  public List<Product> getAllProductExceptDesc() {
    //array of column to fetch
    String[] columns = {
        COLUMN_PID,
        COLUMN_PRODUCT_NAME,
        COLUMN_PRODUCT_PRICE,
        COLUMN_PRODUCT_QUANTITY,
    };

    //sorting orders
    String sortOrder =
        COLUMN_PRODUCT_NAME + " ASC";

    List<Product> productList = new ArrayList<Product>();

    SQLiteDatabase db = this.getReadableDatabase();

    //query the product table
    /**
     * Here query function is used to fetch records from user table this function works like we use sql query.
     * SQL query equivalent to this query function is
     * SELECT p_id,product_name,product_price,product_quantity FROM product ORDER BY product_name;
     */
    Cursor cursor = db.query(TABLE_PRODUCT, //Table to query
        columns,              //columns to return
        null,        //columns for the WHERE clause
        null,     //The values for the WHERE clause
        null,         //group the rows
        null,         //filter by row groups
        sortOrder);         //The sort order

    //Traversing all the rows and add to list
    if (cursor.moveToFirst()) {
      do {
        Product product = new Product();
        product.setP_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_PID))));
        product.setProduct_name(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_NAME)));
        product.setProduct_price(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_PRICE)));
        product
            .setProduct_qauntity(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_QUANTITY)));

        //adding product record to list
        productList.add(product);
      } while (cursor.moveToNext());
    }
    cursor.close();
    db.close();

    //return product list
    return productList;
  }

}
