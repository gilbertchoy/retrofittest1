package com.bort.retrofittest1.Model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    //@SerializedName("name")

    private String id;
    //private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    */
     */
}
