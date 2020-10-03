package com.example.trackmygoods.data;

public class UserLogin {
    private String userID;
    private String password;
    private Boolean status;

    public UserLogin() {
    }

    public UserLogin(String userID, String password, Boolean status) {
        this.userID = userID;
        this.password = password;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
