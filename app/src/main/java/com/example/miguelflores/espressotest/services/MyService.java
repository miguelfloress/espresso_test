package com.example.miguelflores.espressotest.services;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * @author miguel.flores.
 */
public class MyService {

    public void callService(final ServiceCallback<ResponseBody> callback) {
        IGithubCall service = ServiceClient.retrofit.create(IGithubCall.class);
        Call<ResponseBody> call = service.testService();
        call.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                if (callback != null) {
                    callback.onResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (callback != null) {
                    callback.onFailure();
                }
            }
        });
    }
}
