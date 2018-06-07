package com.example.miguelflores.espressotest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.miguelflores.espressotest.R;

public class MockBundleActivity extends AppCompatActivity implements View.OnClickListener {
    Button sendButton;
    EditText textContainer;

    public static Intent createIntent(Context context){
        return new Intent(context, MockBundleActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock_bundle);
        sendButton = findViewById(R.id.sendButton);
        textContainer = findViewById(R.id.text_container);
        sendButton.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,ShowBundleActivity.class);
        intent.putExtra(ShowBundleActivity.KEY_BUNDLE_TEXT,textContainer.getText().toString());
        startActivity(intent);
    }
}
