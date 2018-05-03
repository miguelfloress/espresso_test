package com.example.miguelflores.espressotest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.miguelflores.espressotest.R;

/**
 * @author miguel.flores.
 */
public class IdlingResourcesActivity extends AppCompatActivity {

    private TextView textView;

    public static Intent createIntent(Context context) {
        return new Intent(context, IdlingResourcesActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idling_resources);
        textView = findViewById(R.id.textView_result);
        initListeners();
    }

    private void initListeners() {
        findViewById(R.id.buttonOne).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleButtonOneClicked();
            }
        });
        findViewById(R.id.buttonTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleButtonTwoClicked();
            }
        });
    }

    private void handleButtonOneClicked() {
        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                textView.setText(R.string.async_task_completed);
            }
        };
        asyncTask.execute();
    }

    private void handleButtonTwoClicked() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(R.string.thread_completed);
                    }
                });
            }
        }).start();
    }
}
