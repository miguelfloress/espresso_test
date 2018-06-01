package com.example.miguelflores.espressotest.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.miguelflores.espressotest.R;

/**
 * Created by miguel.flores on 31/05/2018.
 */

public class FirstActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
}
