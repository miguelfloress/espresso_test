package com.example.miguelflores.espressotest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.idling.CountingIdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.miguelflores.espressotest.R;
import com.example.miguelflores.espressotest.presenter.ServicePresenter;
import com.example.miguelflores.espressotest.views.IServiceView;

/**
 * @author miguel.flores
 */

public class ServiceActivity extends AppCompatActivity implements IServiceView {

    private CountingIdlingResource countingIdlingResource = new CountingIdlingResource("SERVICE_IDLING");
    private TextView textView;
    private ServicePresenter presenter;

    public static Intent createIntent(Context context) {
        return new Intent(context, ServiceActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        presenter = new ServicePresenter(this);
        init();
    }

    private void init() {
        textView = findViewById(R.id.textView_result);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fireService();
            }
        });
    }

    private void fireService() {
        countingIdlingResource.increment();
        presenter.fireService();
    }

    public CountingIdlingResource getCountingIdlingResource() {
        return countingIdlingResource;
    }

    @VisibleForTesting
    public void setPresenter(ServicePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showServiceResponse(String text) {
        textView.setText(text);
        countingIdlingResource.decrement();
    }
}
