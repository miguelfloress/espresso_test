package com.example.miguelflores.espressotest.presenter;

import android.support.annotation.VisibleForTesting;

import com.example.miguelflores.espressotest.services.MyService;
import com.example.miguelflores.espressotest.services.ServiceCallback;
import com.example.miguelflores.espressotest.views.IServiceView;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created by miguel.flores.
 */

public class ServicePresenter {

    private MyService myService;
    private IServiceView view;

    public ServicePresenter(IServiceView view) {
        this.view = view;
    }

    public void fireService() {
        myService = new MyService();
        myService.callService(new ServiceCallback<ResponseBody>() {
            @Override
            public void onResponse(ResponseBody response) {
                try {
                    handleResponse(response.string());
                } catch (IOException e) {
                    e.printStackTrace();
                    view.showServiceResponse("error");
                }
            }

            @Override
            public void onFailure() {
                view.showServiceResponse("error");
            }
        });
    }

    @VisibleForTesting
    public void handleResponse(String response) {
        view.showServiceResponse(response);
    }
}
