package com.example.miguelflores.espressotest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.miguelflores.espressotest.R;

/**
 * @author miguel.
 */
public class CheckboxActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, CheckboxActivity.class);
    }

    private CheckBox checkBox;
    private View layout;
    private TextView textViewLabel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checbox);
        init();
        initListeners();
    }

    private void init() {
        checkBox = findViewById(R.id.checkbox);
        layout = findViewById(R.id.ly_checkbox);
        textViewLabel = findViewById(R.id.textView_label);
    }

    private void initListeners() {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox.isChecked()) {
                    handleChecked();
                } else {
                    handleUnChecked();
                }
            }
        });

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBox.setChecked(!checkBox.isChecked());
            }
        });
    }

    private void handleChecked() {
        checkBox.setText("checked");
        textViewLabel.setText("Checked and a short description at the bottom");
        layout.setBackgroundColor(ContextCompat.getColor(CheckboxActivity.this, R.color.colorPrimaryDark));
    }

    private void handleUnChecked() {
        checkBox.setText("unchecked");
        textViewLabel.setText("Un-Checked and a short description at the bottom");
        layout.setBackgroundColor(ContextCompat.getColor(CheckboxActivity.this, R.color.colorPrimary));
    }
}
