package com.strontech.imgautam.databasenewdemo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // we try to run constructor of ImgautamDatabaseAdapter class
    ImgautamDatabaseAdapter imgautamDatabaseAdapter;


    TextInputEditText userName, password, name, namePassword;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userName=findViewById(R.id.editText1);
        password=findViewById(R.id.editText2);
        name=findViewById(R.id.editText3);
        namePassword=findViewById(R.id.editText4);

        btn=findViewById(R.id.addUser);
        //btn.setOnClickListener(addUser());

















        imgautamDatabaseAdapter =new ImgautamDatabaseAdapter(this);

        //when we try to access the database then the database is created
        //getWriteableDatabase() method the other lifecycle methods of SQLiteOpenHelper

        //this is database ref of our
//        SQLiteDatabase sqLiteDatabase= imgautamDatabaseAdapter.getReadableDatabase(); //it give our data on writeable form object





    }

    //add user / insert data on data base on button click
    public void addUser(View view)
    {
        String user=userName.getText().toString().trim();
        String pass=password.getText().toString().trim();

  //      SQLiteDatabase db= imgautamDatabaseAdapter.getReadableDatabase();


        long id =imgautamDatabaseAdapter.insertData(user,pass);
        if (id>0)
        {
            Log.d("tag","helo");
            //Message.message(this, "Unsuccessful");
        }else
        {
            Message.message(this, "Successful");
        }
    }


    ////get all details of database
    public void viewAllDetails(View view)
    {
        String data=imgautamDatabaseAdapter.getAllData();
        Message.message(this, data);
    }


    //get a single row data
    public void getDetails(View view)
    {
        String uName=name.getText().toString().trim();
        String s2=imgautamDatabaseAdapter.getData(uName);
        Message.message(this, s2);
    }

    public void getUserInfo(View view)
    {
        String s1=namePassword.getText().toString().trim();
        String sub1=s1.substring(0,s1.indexOf(" "));
        String sub2=s1.substring(s1.indexOf(" ")+1);

        String s3=imgautamDatabaseAdapter.getDataUP(sub1,sub2);
        Message.message(this, s3);

    }
}
