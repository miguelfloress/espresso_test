package com.example.miguelflores.espressotest.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.miguelflores.espressotest.R;
import com.example.miguelflores.espressotest.activities.ButtonActivity;
import com.example.miguelflores.espressotest.activities.CheckboxActivity;
import com.example.miguelflores.espressotest.activities.EditTextActivity;
import com.example.miguelflores.espressotest.activities.IdlingResourcesActivity;
import com.example.miguelflores.espressotest.activities.ImageViewActivity;
import com.example.miguelflores.espressotest.activities.ListViewActivity;
import com.example.miguelflores.espressotest.activities.RecyclerViewActivity;
import com.example.miguelflores.espressotest.activities.SpinnerActivity;
import com.example.miguelflores.espressotest.activities.TextViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListeners();
    }

    private void initListeners() {
        findViewById(R.id.buttonTextView).setOnClickListener(this);
        findViewById(R.id.buttonEditText).setOnClickListener(this);
        findViewById(R.id.buttonButtonText).setOnClickListener(this);
        findViewById(R.id.buttonCheckboxText).setOnClickListener(this);
        findViewById(R.id.buttonSpinnerText).setOnClickListener(this);
        findViewById(R.id.buttonRecyclerView).setOnClickListener(this);
        findViewById(R.id.buttonImageView).setOnClickListener(this);
        findViewById(R.id.buttonListView).setOnClickListener(this);
        findViewById(R.id.buttonIddlingResources).setOnClickListener(this);
        findViewById(R.id.buttonService).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonTextView:
                startActivity(TextViewActivity.createIntent(this));
                break;
            case R.id.buttonEditText:
                startActivity(EditTextActivity.createIntent(this));
                break;
            case R.id.buttonButtonText:
                startActivity(ButtonActivity.createIntent(this));
                break;
            case R.id.buttonCheckboxText:
                startActivity(CheckboxActivity.createIntent(this));
                break;
            case R.id.buttonSpinnerText:
                startActivity(SpinnerActivity.createIntent(this));
                break;
            case R.id.buttonRecyclerView:
                startActivity(RecyclerViewActivity.createIntent(this));
                break;
            case R.id.buttonImageView:
                startActivity(ImageViewActivity.createIntent(this));
                break;
            case R.id.buttonListView:
                startActivity(ListViewActivity.createIntent(this));
                break;
            case R.id.buttonIddlingResources:
                startActivity(IdlingResourcesActivity.createIntent(this));
                break;
            case R.id.buttonService:
                startActivity(ServiceActivity.createIntent(this));
                break;
        }
    }
}
