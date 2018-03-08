package com.strontech.imgautam.databasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imgautam on 3/3/18.
 */

public class UserDatabase extends SQLiteOpenHelper {


    //Define DB schema
    private static final String DATABASE_NAME="userinfodb";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="USERTABLE";

    //Columns
    private static final String UID="uid";
    private static final String USERNAME="Username";
    private static final String EMAIL="Email";
    private static final String MOB_NUMBER="Mob_number";
    private static final String ADDRESS="Address";

    private Context context;
    //queries

    public UserDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="CREATE TABLE " + TABLE_NAME + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USERNAME + " VARCHAR(255), " + EMAIL + " VARCHAR(255), " + MOB_NUMBER + " NUMBER(13), " + ADDRESS + " VARCHAR(255));";

        try {
            db.execSQL(query);
            Message.message(context, "table created");
        }catch (SQLException e){
          //  e.printStackTrace();
            //Log.d("SQL TABLE",""+e);

            Message.message(context, ""+e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }catch (SQLException e){

            Message.message(context, ""+e);
        }

    }


    public void addUser(UserInfo userInfo){

        SQLiteDatabase db=getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(USERNAME, userInfo.getUserName());
        values.put(EMAIL, userInfo.getEmail());
        values.put(MOB_NUMBER, userInfo.getMob_number());
        values.put(ADDRESS, userInfo.getAddress());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public List<UserInfo> getAllData(){
        ArrayList<UserInfo> listData=new ArrayList<>();

        SQLiteDatabase db=getReadableDatabase();

        String query="SELECT * FROM "+ TABLE_NAME;

        Cursor cursor=db.rawQuery(query, null);

        if (cursor.moveToFirst())
        {
            do {
                UserInfo userInfo=new UserInfo();
                userInfo.setUserName(cursor.getString(1));
                userInfo.setEmail(cursor.getString(2));
                userInfo.setMob_number(cursor.getString(3));
                userInfo.setAddress(cursor.getString(4));

                listData.add(userInfo);
            }while (cursor.moveToNext());


        }
        return listData;
    }
}
