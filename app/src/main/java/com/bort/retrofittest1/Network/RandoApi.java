package com.bort.retrofittest1.Network;

import com.bort.retrofittest1.Model.User;
import com.bort.retrofittest1.Model.UserList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RandoApi {

    //https://reqres.in/api/users?page=2
    @GET("api/users")
    Call<UserList> getUserList(@Query("page") String page);

    //https://reqres.in/api/users/2
    Call<User> getUser(@Path("user") String user);
}
