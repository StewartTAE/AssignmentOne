package com.example.assignmentone;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (primaryKeys = {"name", "phoneNumber"})
public class User {

    public String name;
    public String phoneNumber;
    public String area;
    public String address;
    public String city;
    public String state;
    public String zip;
    public String email;
    public String birthday;

    public User(String name, String phoneNumber, String area, String address, String city, String state, String zip, String email, String birthday) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.area = area;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.birthday = birthday;
    }
}
