package com.strontech.imgautam.databasetest;

/**
 * Created by imgautam on 3/3/18.
 */

public class UserInfo {

    String userName, email, mob_number, address;

    public UserInfo() {
    }

    public UserInfo(String userName, String email, String mob_number, String address) {
        this.userName = userName;
        this.email = email;
        this.mob_number = mob_number;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMob_number() {
        return mob_number;
    }

    public void setMob_number(String mob_number) {
        this.mob_number = mob_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
