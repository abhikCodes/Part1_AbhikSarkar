package com.example.abhik.part1_abhiksarkar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by abhik on 04/02/18.
 */

public interface MainAPI {
    @GET("/tutorial/jsonparsetutorial.txt")
    Call<Main2> getContent();
}
