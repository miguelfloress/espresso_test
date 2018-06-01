package com.example.miguelflores.espressotest.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author miguel.flores.
 */
public class ServiceClient {
    public static final Retrofit retrofit = new Retrofit.Builder()
                                            .baseUrl("https://api.github.com")
                                            .addConverterFactory(GsonConverterFactory.create())
                                            .build();
}
