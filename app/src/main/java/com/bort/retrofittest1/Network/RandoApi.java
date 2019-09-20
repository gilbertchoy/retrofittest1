package com.bort.retrofittest1.Network;

import com.bort.retrofittest1.Model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RandoApi {

    @GET("api/users/{user}")
    Call<User> getUser(@Path("user") String user);
}
