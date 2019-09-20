package com.bort.retrofittest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bort.retrofittest1.Model.User;
import com.bort.retrofittest1.Network.RandoApi;
import com.bort.retrofittest1.Network.RetrofitInstance;

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

        Call<User> call = service.getUser("2");


        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("berttest","response: " + response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("berttest","fail" + t.getLocalizedMessage() + "   " + t.getMessage() + "   " +
                        t.toString() + "    " + t.getCause());
            }
        });


    }
}
