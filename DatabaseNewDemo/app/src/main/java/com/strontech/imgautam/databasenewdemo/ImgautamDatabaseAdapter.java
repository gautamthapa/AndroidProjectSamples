package com.strontech.imgautam.databasenewdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by imgautam on 2/3/18.
 */

public class ImgautamDatabaseAdapter{

    ImgautamHelper helper;
    ImgautamDatabaseAdapter(Context context){
        helper=new ImgautamHelper(context);
    }






    //*TODO: My Idea is here to make method of insert..
    // Because we are going to use private constants of inner class
    // */
    public long insertData(String name, String password)
    {
        SQLiteDatabase db=helper.getReadableDatabase();

        ContentValues contentValues=new ContentValues();


        contentValues.put(ImgautamHelper.NAME,name); // two pairs.. one is NAME(From inner class)=column name and another it's value
        contentValues.put(ImgautamHelper.PASSWORD, password);

        long id=db.insert(ImgautamHelper.TABLE_NAME, null, contentValues); // insert data first table name, second null
                                                                                        // last contentValues of map of our data
        return id;
    }



    //getAllDetails of database table
    public String getAllData()
    {
        SQLiteDatabase db=helper.getReadableDatabase();
        String[] columns={ImgautamHelper.UID, ImgautamHelper.NAME, ImgautamHelper.PASSWORD};

        //cursor object conyaining the subset of data of table
        Cursor cursor=db.query(ImgautamHelper.TABLE_NAME,columns,null, null,null,null,null);


        StringBuffer buffer=new StringBuffer();
        //making while loop to before the first row to cursor and moveToNext,1, 2, 3 and so on...
        while (cursor.moveToNext())
        {
            int cid=cursor.getInt(0);
            String name=cursor.getString(1);
            String pass=cursor.getString(2);
            buffer.append(cid+" "+name+" "+pass+"\n");
        }
        return buffer.toString();

    }

    //get a single row
    public String getData(String name)
    {
        SQLiteDatabase db=helper.getReadableDatabase();
        String[] columns={ImgautamHelper.NAME, ImgautamHelper.PASSWORD};

        //cursor object conyaining the subset of data of table
        Cursor cursor=db.query(ImgautamHelper.TABLE_NAME,columns,ImgautamHelper.NAME+" = '"+name+"'", null,null,null,null);


        StringBuffer buffer=new StringBuffer();
        //making while loop to before the first row to cursor and moveToNext,1, 2, 3 and so on...
        while (cursor.moveToNext())
        {
            int index1=cursor.getColumnIndex(ImgautamHelper.NAME);
            int index2=cursor.getColumnIndex(ImgautamHelper.PASSWORD);
            String personName=cursor.getString(index1);
            String pass=cursor.getString(index2);
            buffer.append(personName+" "+pass+"\n");
        }
        return buffer.toString();

    }


    //getting a particular data according to username and password
    public String getDataUP(String name, String passowrd)
    {
        SQLiteDatabase db=helper.getReadableDatabase();
        String[] columns={ImgautamHelper.UID};
        String[] selectionArgs={name, passowrd};   // this is subtitute of the =? of query statement runtime


        //cursor object containing the subset of data of table
        Cursor cursor=db.query(ImgautamHelper.TABLE_NAME,columns,ImgautamHelper.NAME+" =? AND "+ ImgautamHelper.PASSWORD+" =?", selectionArgs,null,null,null);


        StringBuffer buffer=new StringBuffer();
        //making while loop to before the first row to cursor and moveToNext,1, 2, 3 and so on...
        while (cursor.moveToNext())
        {
            int index1=cursor.getColumnIndex(ImgautamHelper.UID);
            String personId=cursor.getString(index1);
            buffer.append(personId+"\n");
        }
        return buffer.toString();
    }

    static class ImgautamHelper extends SQLiteOpenHelper {
        //make these all private and constant non changeable
        //static because we can use any where program without class
        //name inside program..

        private static final String DATABASE_NAME="gtmdatabase";
        private static final String TABLE_NAME="USERTABLE";
        private static final int DATABASE_VERSION=10;  //2. then change the version
        private static final String UID="_id";
        private static final String NAME="Name";
        private static final String PASSWORD="Password";


        //1. check to onUpgrade method  .. add another column
        // private static final String ADDRESS="Address";


        private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME +" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME +" VARCHAR(255), "+PASSWORD+" VARCHAR(255));";
        private static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public ImgautamHelper(Context context){
            //We define superclass constructor
            super(context, DATABASE_NAME,null,DATABASE_VERSION);
            this.context=context;

            //print the message in the form of toast using another class
            Message.message(context,"constructor is called");
        }



        //onCreate() is called first time when database is created
        //otherwise it's not called
        @Override
        public void onCreate(SQLiteDatabase db) {



            try {
                //CREATE TABLE  this query throws exception
                db.execSQL(CREATE_TABLE);
                Message.message(context,"onCreate is called");
            }catch (SQLException e){
                // e.printStackTrace();

                //print message using the class Message
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            //DROP TABLE IF EXISTS AND CREATE NEW ONE

            try {
                Message.message(context,"onUpgrade is called");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (SQLException e){
                Message.message(context,""+e);
            }
        }
    }





}
