package com.example.miguelflores.espressotest.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author miguel.flores.
 */
public interface IGithubCall {

    @GET("/users/MiguelArturoFlores")
    Call<ResponseBody> testService();

}
