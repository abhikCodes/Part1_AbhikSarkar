package com.example.abhik.part1_abhiksarkar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvPic;
    MainAdapter mainAdapter;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        rvPic = (RecyclerView) findViewById(R.id.rvPicList);
        rvPic.setLayoutManager(new LinearLayoutManager(this));
        mainAdapter = new MainAdapter(this, new ArrayList<Main2.Country>());
        rvPic.setAdapter(mainAdapter);


        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl("http://www.androidbegin.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();
        MainAPI mainAPI = retrofit.create(MainAPI.class);
        Callback<Main2> mainCallback = new Callback<Main2>() {
            @Override
            public void onResponse(Call<Main2> call, Response<Main2> response) {
                Log.d(TAG, "onResponse: " + response.body());
                mainAdapter.updateMains(response.body().getWorldpopulation());
                System.out.println("[Abhik__] res");
            }
            @Override
            public void onFailure(Call<Main2> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t);
                    System.out.println("[Abhik__] res1");
            }
        };
        mainAPI.getContent().enqueue(mainCallback);
    }
}
