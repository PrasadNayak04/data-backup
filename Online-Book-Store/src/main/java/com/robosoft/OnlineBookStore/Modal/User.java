package com.robosoft.OnlineBookStore.Modal;

import java.util.List;

public class User {

    private String userEmailId;
    private String userName;
    private String phoneNumber;

    public User() {
    }

    public User(String userName, String email, String phoneNumber) {
        this.userName = userName;
        this.userEmailId = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
