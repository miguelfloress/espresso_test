package com.example.miguelflores.espressotest.services;

import okhttp3.ResponseBody;

/**
 * @author miguel.flores.
 */
public interface ServiceCallback<T> {

    void onResponse(T response);

    void onFailure();

}
