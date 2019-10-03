package com.bort.retrofittest1.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserShell {

    @SerializedName("data")
    private User user = null;

    public User getData() {
        return user;
    }

    public void setData(String page) {
        this.user = user;
    }


}
