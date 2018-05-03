package com.example.miguelflores.espressotest.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.miguelflores.espressotest.R;

/**
 * Created by miguel.flores.
 */
public class TextViewActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewSubtitle1;
    private TextView textViewSubtitle2;

    public static Intent createIntent(Context context) {
        return new Intent(context, TextViewActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        initView();
        initListeners();
    }

    private void initView() {
        textViewSubtitle1 = (TextView) findViewById(R.id.textViewHideSubtitle1);
        textViewSubtitle2 = (TextView) findViewById(R.id.textViewHideSubtitle2);
    }

    private void initListeners() {
        findViewById(R.id.textViewTitle).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textViewTitle:
                handleTitleClicked();
                break;
        }
    }

    private void handleTitleClicked() {
        if (textViewSubtitle1.getVisibility() == View.VISIBLE) {
            textViewSubtitle1.setVisibility(View.GONE);
        } else {
            textViewSubtitle1.setVisibility(View.VISIBLE);
        }
    }
}
