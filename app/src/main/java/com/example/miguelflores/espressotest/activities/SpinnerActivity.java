package com.example.miguelflores.espressotest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.miguelflores.espressotest.R;

/**
 * @author miguel.flores.
 */
public class SpinnerActivity extends AppCompatActivity {

    private TextView textView;
    private Spinner spinner;

    public static Intent createIntent(Context context) {
        return new Intent(context, SpinnerActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        init();
        initListeners();
    }

    private void init() {
        textView = findViewById(R.id.textView_selection);
        spinner = findViewById(R.id.spinner);
    }

    private void initListeners() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText((String) adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
