package com.example.assignmentone;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (primaryKeys = {"name", "phoneNumber"})
public class User {
    @NonNull
    public String name;
    @NonNull
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

    public String getName() { return name; }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
