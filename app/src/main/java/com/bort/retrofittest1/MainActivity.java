package com.bort.retrofittest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.bort.retrofittest1.Model.User;
import com.bort.retrofittest1.Model.UserList;
import com.bort.retrofittest1.Network.RandoApi;
import com.bort.retrofittest1.Network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "https://reqres.in/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        RandoApi service = RetrofitInstance.getRetrofitInstance().create(RandoApi.class);
        Call<UserList> call = service.getUserList("2");
        call.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                Log.d("berttest","response: " + response.body());
                List<User> userList = new ArrayList<User>();
                userList = response.body().getData();
                Log.d("berttest", "berttest user id:" + userList.get(0).getId());

                User user = userList.get(0);

            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                Log.d("berttest","fail" + t.getLocalizedMessage() + "   " + t.getMessage() + "   " +
                        t.toString() + "    " + t.getCause());
            }
        });


        Call<User> call1 = service.getUser("2");
        call1.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("berttest","user response: " + response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("berttest user failure: ","fail" + t.getLocalizedMessage() + "   " + t.getMessage() + "   " +
                        t.toString() + "    " + t.getCause());
            }

        });
        

    }
}
