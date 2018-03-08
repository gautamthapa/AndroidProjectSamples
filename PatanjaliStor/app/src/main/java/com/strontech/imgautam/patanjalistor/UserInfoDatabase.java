package com.strontech.imgautam.patanjalistor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by imgautam on 3/3/18.
 */

public class UserInfoDatabase extends SQLiteOpenHelper {

    //Define DB schema
    private static final String DATABASE_NAME="userinfodb";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="USERTABLE";

    //Columns
    private static final String UID="uid";
    private static final String USERNAME="Username";
    private static final String MOB_NUMBER="Mob_number";
    private static final String EMAIL="Email";
    private static final String ADDRESS="Address";

    private Context context;
    //queries
    private static final String CREATE_TABLE="CREATE TABLE "+
            TABLE_NAME +" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+USERNAME
            +" VARCHAR(40), "+MOB_NUMBER+" NUMBER(13), "+EMAIL+" VARCHAR(40), "+
            ADDRESS+" VARCHAR(255));";
    private static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;



    public UserInfoDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
       this.context=context;
        TestMessage.message(context,"constructor called");
    }


    //create table
    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE);
            TestMessage.message(context,"oncreate called");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            db.execSQL(DROP_TABLE);
            TestMessage.message(context,"oncreate called");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    //method for adding users
    public long addUser(UserInfo userInfo)
    {
        SQLiteDatabase db=getWritableDatabase();

        //store values as key pair
        ContentValues values=new ContentValues();
        values.put(USERNAME, userInfo.getUserName());
        values.put(MOB_NUMBER, userInfo.getMob_number());
        values.put(EMAIL, userInfo.getEmail());
        values.put(ADDRESS, userInfo.getAddress());

       long id= db.insert(TABLE_NAME, null,values);

       db.close();
       return id;
    }


    public UserInfo getNamePass (String name, String pass)
    {

        SQLiteDatabase db=getReadableDatabase();

        String[] columns={MOB_NUMBER,EMAIL};
        String[] selectionArgs={name, pass};

        Cursor cursor=db.query(TABLE_NAME, new String[]{MOB_NUMBER,EMAIL},
                MOB_NUMBER+" =? AND "+
                        EMAIL+" =?",new String[]{name,pass},null,null,null);

        if (cursor !=null)
            cursor.moveToFirst();


        UserInfo userInfo=new UserInfo(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
        return userInfo;


    }
}
