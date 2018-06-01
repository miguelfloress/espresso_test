package com.example.miguelflores.espressotest.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.miguelflores.espressotest.R;

public class ShowBundleActivity extends AppCompatActivity {

    Bundle bundle;
    TextView textContainer;
    public static final String KEY_BUNDLE_TEXT = "key_bundle_text";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bundle);
        textContainer = findViewById(R.id.text_container);
        bundle = getIntent().getExtras();
        textContainer.setText(bundle.getString(KEY_BUNDLE_TEXT));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
}
