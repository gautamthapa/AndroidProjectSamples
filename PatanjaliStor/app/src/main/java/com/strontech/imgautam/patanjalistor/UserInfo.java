package com.strontech.imgautam.patanjalistor;

/**
 * Created by imgautam on 3/3/18.
 */

public class UserInfo  {

    //int uid;
    String userName, mob_number, email, address;

    public UserInfo() {

    }

    public UserInfo(String userName, String mob_number, String email, String address) {
        this.userName = userName;
        this.mob_number = mob_number;
        this.email = email;
        this.address = address;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMob_number() {
        return mob_number;
    }

    public void setMob_number(String mob_number) {
        this.mob_number = mob_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
